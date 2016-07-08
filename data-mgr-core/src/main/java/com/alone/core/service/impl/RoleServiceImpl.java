package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alone.common.entity.Role;
import com.alone.core.mapper.RoleMapper;
import com.alone.thrift.service.RoleService;
import com.alone.thrift.struct.RoleStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/8 11:06
 */
@ThriftService
@Slf4j
public class RoleServiceImpl implements RoleService.Iface {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleStruct> roles(long id) throws TException {
        List<Role> roles = roleMapper.select(null);
        List<RoleStruct> result = new ArrayList<>();
        result.add(new RoleStruct());
        log.debug(JSONArray.toJSONString(roles));
        return result;
    }
}
