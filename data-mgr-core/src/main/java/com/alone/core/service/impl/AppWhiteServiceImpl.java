package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.AppWhite;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppWhiteMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.thrift.service.AppWhiteService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class AppWhiteServiceImpl implements AppWhiteService.Iface {

    @Autowired
    private AppWhiteMapper appWhiteMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public long add(AppWhiteStruct bean) throws InvalidOperation, TException {
        AppWhite app = new AppWhite();
        Utils.java2Thrift(app, bean);
        app.setId(Utils.generateUUID());
        app.setCreate_time(new Date());
        appWhiteMapper.insertSelective(app);
        return app.getId();
    }

    @Override
    public boolean update(AppWhiteStruct bean) throws InvalidOperation, TException {
        AppWhite app = new AppWhite();
        Utils.java2Thrift(app, bean);
        if (app.getId() == null || app.getId() <= 0)
            return false;
        return appWhiteMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        return appWhiteMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, appWhiteMapper);
    }

    @Override
    public boolean changeAppFile(long id, ResourcesStruct resources) throws InvalidOperation, TException {
        AppWhite app = appWhiteMapper.selectByPrimaryKey(id);
        if (app == null)
            throw new InvalidOperation(500, "应用不存在");
        long rid = Util.changeAppFile(id, resources, resourcesMapper);
        app.setResources_id(rid);
        return appWhiteMapper.updateByPrimaryKeySelective(app) > 0;
    }
}
