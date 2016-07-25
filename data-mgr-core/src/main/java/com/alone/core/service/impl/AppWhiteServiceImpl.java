package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.AppWhite;
import com.alone.common.entity.UserRef;
import com.alone.common.enums.RefType;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppWhiteMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.UserRefMapper;
import com.alone.thrift.service.AppWhiteService;
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
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class AppWhiteServiceImpl implements AppWhiteService.Iface {

    @Autowired
    private AppWhiteMapper appWhiteMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;
    @Autowired
    private UserRefMapper userRefMapper;

    @Override
    public long add(AppWhiteStruct bean) throws InvalidOperation, TException {
        AppWhite app = new AppWhite();
        Utils.java2Thrift(app, bean);
        app.setId(Utils.generateUUID());
        app.setCreate_time(new Date());
        appWhiteMapper.insertSelective(app);

        UserRef ref = new UserRef();
        ref.setUser_id(1L);
        ref.setRef_id(app.getId());
        ref.setType(RefType.WHITE.getVal());
        userRefMapper.insert(ref);
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
        Example delRef = new Example(UserRef.class);
        delRef.createCriteria().andEqualTo("user_id", 1L).andEqualTo("ref_id", id).andEqualTo("type", RefType.WHITE.getVal());
        userRefMapper.deleteByExample(delRef);
        if (appWhiteMapper.deleteByPrimaryKey(id) <= 0)
            throw new InvalidOperation(500, "操作失败");
        return true;
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
        Long rid = Util.changeAppFile(resources, resourcesMapper);
        if (rid == null)
            throw new InvalidOperation(500, "操作失败");
        app.setResources_id(rid);
        return appWhiteMapper.updateByPrimaryKeySelective(app) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String allList(long user) throws InvalidOperation, TException {
        if (user > 0) {
            return JSONArray.toJSONString(appWhiteMapper.allList(user), SerializerFeature.WriteMapNullValue);
        }
        return JSONArray.toJSONString(appWhiteMapper.selectAll(), SerializerFeature.WriteMapNullValue);
    }
}
