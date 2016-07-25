package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.App;
import com.alone.common.entity.AppActive;
import com.alone.common.entity.InstallActive;
import com.alone.common.entity.UserRef;
import com.alone.common.enums.RefType;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppActiveMapper;
import com.alone.core.mapper.AppMapper;
import com.alone.core.mapper.InstallActiveMapper;
import com.alone.core.mapper.UserRefMapper;
import com.alone.thrift.service.AppActiveService;
import com.alone.thrift.service.InstallActiveService;
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
public class InstallActiveServiceImpl implements InstallActiveService.Iface {

    @Autowired
    private InstallActiveMapper installActiveMapper;

    @Autowired
    private UserRefMapper userRefMapper;

    @Override
    public long add(InstallActiveStruct bean) throws InvalidOperation, TException {
        InstallActive active = new InstallActive();
        Utils.java2Thrift(active, bean);
        active.setCreate_time(new Date());
        active.setId(Utils.generateUUID());
        installActiveMapper.insertSelective(active);

        UserRef ref = new UserRef();
        ref.setUser_id(1L);
        ref.setRef_id(active.getId());
        ref.setType(RefType.ACTIVE.getVal());
        userRefMapper.insert(ref);
        return active.getId();
    }

    @Override
    public boolean update(InstallActiveStruct bean) throws InvalidOperation, TException {
        InstallActive active = new InstallActive();
        Utils.java2Thrift(active, bean);
        if (active.getId() == null || active.getId() <= 0)
            throw new InvalidOperation(500, "操作失败");
        return installActiveMapper.updateByPrimaryKeySelective(active) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example delRef = new Example(UserRef.class);
        delRef.createCriteria().andEqualTo("user_id", 1L).andEqualTo("ref_id", id).andEqualTo("type", RefType.ACTIVE.getVal());
        userRefMapper.deleteByExample(delRef);

        boolean isDel = installActiveMapper.deleteByPrimaryKey(id) > 0;
        if (!isDel) {
            throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, installActiveMapper);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String allList(long user) throws InvalidOperation, TException {
        if (user > 0) {
            return JSONArray.toJSONString(installActiveMapper.allList(user), SerializerFeature.WriteMapNullValue);
        }
        return JSONArray.toJSONString(installActiveMapper.selectAll(), SerializerFeature.WriteMapNullValue);
    }
}
