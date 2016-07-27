package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Model;
import com.alone.common.entity.RootConfig;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.ModelRefMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.RootConfigMapper;
import com.alone.thrift.service.RootConfigService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

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
    private ModelRefMapper modelRefMapper;
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
        Example del = new Example(Model.class);
        del.createCriteria().andEqualTo("ref_id", id).andEqualTo("type", 1);
        modelRefMapper.deleteByExample(del);
        if (rootConfigMapper.deleteByPrimaryKey(id) <= 0)
            throw new InvalidOperation(500, "操作失败");
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, rootConfigMapper);
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
