package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.App;
import com.alone.common.entity.AppImg;
import com.alone.common.entity.Resources;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppImgMapper;
import com.alone.core.mapper.AppMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.thrift.service.AppService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class AppServiceImpl implements AppService.Iface {

    @Autowired
    private AppMapper appMapper;
    @Autowired
    private AppImgMapper appImgMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public long add(AppStruct bean) throws InvalidOperation, TException {
        App app = new App();
        Utils.java2Thrift(app, bean);
        app.setId(Utils.generateUUID());
        app.setCreate_time(new Date());
        app.setPrice(BigDecimal.valueOf(bean.getPrice()));
        appMapper.insertSelective(app);
        return app.getId();
    }

    @Override
    public boolean update(AppStruct bean) throws InvalidOperation, TException {
        App app = new App();
        Utils.java2Thrift(app, bean);
        if (app.getId() == null || app.getId() <= 0)
            return false;
        app.setPrice(BigDecimal.valueOf(bean.getPrice()));
        return appMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example example = new Example(AppImg.class);
        example.createCriteria().andEqualTo("app_id", id);
        appImgMapper.deleteByExample(example);

        boolean isDel = appMapper.deleteByPrimaryKey(id) > 0;
        if (!isDel) {
            throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct appByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, appMapper);
    }

    @Override
    public boolean changeAppFile(long id, ResourcesStruct resources) throws InvalidOperation, TException {
        App app = appMapper.selectByPrimaryKey(id);
        if (app == null)
            throw new InvalidOperation(500, "应用不存在");
        if (resources.getId() > 0) {
            Resources db = resourcesMapper.selectByPrimaryKey(resources.getId());
            if (db != null) {
                app.setResources_id(resources.getId());
                return appMapper.updateByPrimaryKeySelective(app) > 0;
            }
        }
        Resources r = new Resources();
        Utils.java2Thrift(r, resources);
        r.setId(Utils.generateUUID());
        r.setCreate_time(new Date());
        resourcesMapper.insertSelective(r);
        app.setResources_id(r.getId());
        return appMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    public boolean changeAppImg(long id, List<ResourcesStruct> resources) throws InvalidOperation, TException {
        if (resources == null || resources.size() <= 0)
            return false;
        App app = appMapper.selectByPrimaryKey(id);
        if (app == null)
            throw new InvalidOperation(500, "应用不存在");
        Example example = new Example(AppImg.class);
        example.createCriteria().andEqualTo("app_id", id);
        appImgMapper.deleteByExample(example);
        for (ResourcesStruct resource : resources) {
            Long rid = null;
            if (resource.getId() > 0) {
                Resources db = resourcesMapper.selectByPrimaryKey(resource.getId());
                if (db != null) {
                    rid = db.getId();
                }
            } else {
                if (StringUtils.isEmpty(resource.getMd5()))
                    continue;
                Resources r = new Resources();
                Utils.java2Thrift(r, resource);
                r.setId(Utils.generateUUID());
                r.setCreate_time(new Date());
                resourcesMapper.insertSelective(r);
                rid = r.getId();
            }
            AppImg img = new AppImg();
            img.setResources_id(rid);
            img.setApp_id(id);
            appImgMapper.insert(img);
        }
        return true;
    }

    @Override
    public List<ResourcesStruct> imgs(long id) throws InvalidOperation, TException {
        List<Resources> resourcesList = appMapper.getImgs(id);
        return getResourcesStructs(resourcesList);
    }

    private List<ResourcesStruct> getResourcesStructs(List<Resources> resources) {
        List<ResourcesStruct> result = new ArrayList<>();
        if (resources != null && !resources.isEmpty()) {
            for (Resources r : resources) {
                result.add(Utils.java2Thrift(new ResourcesStruct()
                                .setCreate_time(r.getCreate_time().getTime())
                        , r));
            }
        }
        return result;
    }
}
