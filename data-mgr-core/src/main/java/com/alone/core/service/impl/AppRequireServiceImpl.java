package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.App;
import com.alone.common.entity.AppImg;
import com.alone.common.entity.AppRequire;
import com.alone.common.entity.Resources;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppImgMapper;
import com.alone.core.mapper.AppMapper;
import com.alone.core.mapper.AppRequireMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.thrift.service.AppRequireService;
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
public class AppRequireServiceImpl implements AppRequireService.Iface {

    @Autowired
    private AppRequireMapper appRequireMapper;
    @Autowired
    private AppImgMapper appImgMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public long add(AppRequireStruct bean) throws InvalidOperation, TException {
        AppRequire app = new AppRequire();
        Utils.java2Thrift(app, bean);
        app.setId(Utils.generateUUID());
        app.setCreate_time(new Date());
        appRequireMapper.insertSelective(app);
        return app.getId();
    }

    @Override
    public boolean update(AppRequireStruct bean) throws InvalidOperation, TException {
        AppRequire app = new AppRequire();
        Utils.java2Thrift(app, bean);
        if (app.getId() == null || app.getId() <= 0)
            return false;
        return appRequireMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        return Util.removeApp(id, appImgMapper, appRequireMapper);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, appRequireMapper);
    }

    @Override
    public boolean changeAppFile(long id, ResourcesStruct resources) throws InvalidOperation, TException {
        AppRequire app = appRequireMapper.selectByPrimaryKey(id);
        if (app == null)
            throw new InvalidOperation(500, "应用不存在");
        long rid = Util.changeAppFile(id, resources, resourcesMapper);
        app.setResources_id(rid);
        return appRequireMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    public boolean changeAppImg(long id, List<ResourcesStruct> resources) throws InvalidOperation, TException {
        return Util.changeAppImg(id, resources, appRequireMapper, appImgMapper, resourcesMapper);
    }

    @Override
    public List<ResourcesStruct> imgs(long id) throws InvalidOperation, TException {
        List<Resources> resourcesList = appImgMapper.getImgs(id);
        return getResourcesStructs(resourcesList);
    }

    @Override
    public String allList() throws InvalidOperation, TException {
        return JSONArray.toJSONString(appRequireMapper.selectAll(), SerializerFeature.WriteMapNullValue);
    }

    private List<ResourcesStruct> getResourcesStructs(List<Resources> resources) {
        List<ResourcesStruct> result = new ArrayList<>();
        if (resources != null && !resources.isEmpty()) {
            for (Resources r : resources) {
                result.add(Utils.java2Thrift(new ResourcesStruct()
                                .setCreate_time(r.getCreate_time().getTime()), r));
            }
        }
        return result;
    }
}
