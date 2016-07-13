package com.alone.core.service.impl;

import com.alone.common.entity.Role;
import com.alone.common.entity.User;
import com.alone.common.entity.UserRole;
import com.alone.common.service.EmailNotifyService;
import com.alone.common.util.Utils;
import com.alone.core.mapper.*;
import com.alone.thrift.service.UserService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.UserStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/8 11:06
 */
@ThriftService
@Slf4j
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class UserServiceImpl implements UserService.Iface {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private EmailNotifyService emailNotifyService;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<UserStruct> users() throws InvalidOperation, TException {
        List<User> users = userMapper.selectAll();
        return getUserStructs(users);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<UserStruct> usersByUser() throws InvalidOperation, TException {
        return null;
    }

    @Override
    public long add(UserStruct bean) throws InvalidOperation, TException {
        String pids = "0";
        if (bean.getPid() > 0) {
            User parent = userMapper.selectByPrimaryKey(bean.getPid());
            pids = StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids();
        }
        User u = new User();
        Utils.java2Thrift(u, bean);
        u.setId(Utils.generateUUID());
        u.setCreate_time(new Date());
        u.setPids(pids);
        String pwd = u.getPassword();
        if (StringUtils.isEmpty(pwd))
            pwd = RandomStringUtils.randomAlphanumeric(6);
        pwd = Utils.MD5(u.getUsername() + pwd);
        u.setPassword(pwd);
        userMapper.insertSelective(u);
        return u.getId();
    }

    @Override
    public boolean update(UserStruct bean) throws InvalidOperation, TException {
        String pids = null;
        if (bean.getPid() > 0) {
            User parent = userMapper.selectByPrimaryKey(bean.getPid());
            pids = StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids();
        }
        User u = userMapper.selectByPrimaryKey(bean.getId());
        if (u == null)
            throw new InvalidOperation(500, "用户不存在");
        Utils.java2Thrift(u, bean);
        if (u.getId() == null || u.getId() <= 0)
            return false;
        if (bean.isSetStatus()) {
            userMapper.updateChildStatus(u.getId(), u.getStatus());
        }
        u.setPids(pids);
        return userMapper.updateByPrimaryKeySelective(u) > 0;
    }

    @Override
    public boolean setRoles(long user, long parent, List<Long> roles) throws InvalidOperation, TException {
        //验证角色是否超出当前用户
        List<Role> parentRoles = roleMapper.listChildByUser(parent);
        List<Role> oldRoles = roleMapper.listChildByUser(user);
        for (Long role : roles) {
            boolean have = false;
            for (Role userRole : parentRoles) {
                if (userRole.getId().longValue() == role.longValue()) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                throw new InvalidOperation(500, "角色超出当前用户权限");
            }
        }
        //清空之前的角色
        Example example = new Example(UserRole.class);
        example.createCriteria().andEqualTo("user_id", user);
        userRoleMapper.deleteByExample(example);

        //设置角色
        int count = 0;
        for (Long role : roles) {
            UserRole roleMenu = new UserRole();
            roleMenu.setUser_id(user);
            roleMenu.setRole_id(role);
            roleMenu.setCreate_time(new Date());
            count += userRoleMapper.insert(roleMenu);
        }

        //清理权限
        Set<Long> back = new HashSet<>();
        StringBuilder backString = new StringBuilder();
        for (Role oldRole : oldRoles) {
            boolean have = false;
            for (Long role : roles) {
                if (oldRole.getId().longValue() == role.longValue()) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                back.add(oldRole.getId());
                backString.append(oldRole.getId()).append(",");
            }
        }
        //有回收功能点
        if (!back.isEmpty()) {
            backString.deleteCharAt(backString.length() - 1);
            userMapper.deleteUserChildrenRoles(user, backString.toString());
        }
        return count == roles.size();
    }

    @Override
    public boolean login(String username, String password) throws InvalidOperation, TException {
        User user = getByUsername(username);
        return user != null && user.getPassword().equals(Utils.MD5(username + password));
    }

    private User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }

    private List<UserStruct> getUserStructs(List<User> users) {
        List<UserStruct> result = new ArrayList<>();
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                result.add(Utils.java2Thrift(new UserStruct()
                        .setCreate_time(user.getCreate_time().getTime())
                        , user));
            }
        }
        return result;
    }
}
