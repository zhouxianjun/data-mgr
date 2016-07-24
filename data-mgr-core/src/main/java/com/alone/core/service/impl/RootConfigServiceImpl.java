package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.RootConfig;
import com.alone.common.entity.RootModel;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.RootConfigMapper;
import com.alone.core.mapper.RootModelMapper;
import com.alone.thrift.service.RootConfigService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午12:14
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class RootConfigServiceImpl implements RootConfigService.Iface {
    @Autowired
    private RootConfigMapper rootConfigMapper;
    @Autowired
    private RootModelMapper rootModelMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;
    @Override
    public long add(RootConfigStruct bean) throws InvalidOperation, TException {
        RootConfig rootConfig = new RootConfig();
        Utils.java2Thrift(rootConfig, bean);
        rootConfig.setId(Utils.generateUUID());
        rootConfig.setCreate_time(new Date());
        rootConfigMapper.insertSelective(rootConfig);
        return rootConfig.getId();
    }

    @Override
    public boolean update(RootConfigStruct bean) throws InvalidOperation, TException {
        RootConfig rootConfig = new RootConfig();
        Utils.java2Thrift(rootConfig, bean);
        if (rootConfig.getId() == null || rootConfig.getId() <= 0)
            return false;
        return rootConfigMapper.updateByPrimaryKeySelective(rootConfig) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example del = new Example(RootModel.class);
        del.createCriteria().andEqualTo("root_id", id);
        rootModelMapper.deleteByExample(del);
        if (rootConfigMapper.deleteByPrimaryKey(id) <= 0)
            throw new InvalidOperation(500, "操作失败");
        return true;
    }

    @Override
    public boolean addModel(RootModelStruct model, long id) throws TException {
        Example example = new Example(RootModel.class);
        example.createCriteria()
                .andEqualTo("brand_id", model.getBrand_id())
                .andEqualTo("model_id", model.getModel_id())
                .andEqualTo("version_id", model.getVersion_id())
                .andEqualTo("base_version_id", model.getBase_version_id())
                .andEqualTo("root_id", id);
        if (rootModelMapper.selectCountByExample(example) > 0) {
            throw new InvalidOperation(500, "已经存在");
        }
        RootModel rootModel = new RootModel();
        Utils.java2Thrift(rootModel, model);
        rootModel.setId(Utils.generateUUID());
        rootModel.setRoot_id(id);
        rootModelMapper.insert(rootModel);
        return true;
    }

    @Override
    public boolean removeModel(long id) throws InvalidOperation, TException {
        return rootModelMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, rootConfigMapper);
    }

    @Override
    public PageStruct listModelByPage(PageParamStruct page, long id) throws InvalidOperation, TException {
        Page<RootModel> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = rootConfigMapper.listModelByPage(p, id, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    @Override
    public boolean changeAppFile(long id, ResourcesStruct resources) throws InvalidOperation, TException {
        RootConfig rootConfig = rootConfigMapper.selectByPrimaryKey(id);
        if (rootConfig == null)
            throw new InvalidOperation(500, "ROOT配置不存在");
        Long rid = Util.changeAppFile(resources, resourcesMapper);
        if (rid == null)
            throw new InvalidOperation(500, "操作失败");
        rootConfig.setResources_id(rid);
        return rootConfigMapper.updateByPrimaryKeySelective(rootConfig) > 0;
    }
}
