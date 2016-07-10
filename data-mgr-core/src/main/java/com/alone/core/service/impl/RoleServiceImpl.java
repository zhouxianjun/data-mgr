package com.alone.core.service.impl;

import com.alone.common.entity.Role;
import com.alone.common.util.Utils;
import com.alone.core.mapper.RoleMapper;
import com.alone.thrift.service.RoleService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.RoleStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/8 11:06
 */
@ThriftService
@Slf4j
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class RoleServiceImpl implements RoleService.Iface {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<RoleStruct> roles() throws TException {
        List<Role> roles = roleMapper.select(null);
        List<RoleStruct> result = new ArrayList<>();
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                result.add(Utils.java2Thrift(new RoleStruct()
                        .setCreate_time(role.getCreate_time().getTime())
                        .setUpdate_time(role.getUpdate_time().getTime()), role));
            }
        }
        return result;
    }

    @Override
    public long add(String name, long pid) throws TException {
        Role parent = roleMapper.selectByPrimaryKey(pid);
        Role role = new Role();
        role.setId(Utils.generateUUID());
        role.setCreate_time(new Date());
        role.setName(name);
        role.setPid(pid);
        role.setStatus(Boolean.TRUE);
        role.setUpdate_time(new Date());
        role.setPids(StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids());
        roleMapper.insertSelective(role);
        return role.getId();
    }

    @Override
    public boolean update(long id, String name, boolean status, long pid) throws TException {
        Role role = roleMapper.selectByPrimaryKey(id);
        roleMapper.updateChildStatus(id, status);
        if (role.getPid() != pid) {
            Role parent = roleMapper.selectByPrimaryKey(pid);
            role.setPids(StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids());
        }
        role.setName(name);
        role.setPid(pid);
        role.setStatus(status);
        role.setUpdate_time(new Date());
        roleMapper.updateByPrimaryKeySelective(role);
        return true;
    }

    @Override
    public boolean updateStatus(List<Long> ids, boolean status) throws TException {
        roleMapper.updateStatus(ids.toArray(new Long[ids.size()]), status);
        return true;
    }
}
