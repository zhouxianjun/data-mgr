package com.alone.core.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alone.common.entity.Menu;
import com.alone.common.entity.Role;
import com.alone.common.entity.RoleMenu;
import com.alone.common.util.Utils;
import com.alone.core.mapper.MenuMapper;
import com.alone.core.mapper.RoleMapper;
import com.alone.core.mapper.RoleMenuMapper;
import com.alone.thrift.service.RoleService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.RoleStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import lombok.extern.slf4j.Slf4j;
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
public class RoleServiceImpl implements RoleService.Iface {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<RoleStruct> roles() throws TException {
        List<Role> roles = roleMapper.selectAll();
        return getRoleStructs(roles);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<RoleStruct> rolesByUser(long user) throws TException {
        List<Role> roles = roleMapper.listChildByUser(user);
        return getRoleStructs(roles);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<RoleStruct> rolesBySetUser(long user, long parent) throws TException {
        if (user == parent) {
            throw new InvalidOperation(500, "自己不能给自己设置角色");
        }
        List<Role> parentRoles = roleMapper.listChildByUser(parent);
        List<Role> userRoles = roleMapper.listChildByUser(user);
        List<RoleStruct> result = getRoleStructs(parentRoles);
        for (RoleStruct struct : result) {
            boolean ow = false;
            for (Role userRole : userRoles) {
                if (userRole.getId() == struct.getId()) {
                    ow = true;
                    break;
                }
            }
            struct.setOw(ow);
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
        return roleMapper.updateByPrimaryKeySelective(role) > 0;
    }

    @Override
    public boolean updateStatus(List<Long> ids, boolean status) throws TException {
        return roleMapper.updateStatus(ids.toArray(new Long[ids.size()]), status) > 0;
    }

    @Override
    public boolean setMenus(long role, long user, List<Long> menus) throws TException {
        //验证功能点是否超权限
        List<Menu> userMenus = menuMapper.listByUser(user);
        List<Menu> oldMenus = menuMapper.listByRole(role);
        for (Long menu : menus) {
            boolean have = false;
            for (Menu userMenu : userMenus) {
                if (userMenu.getId().longValue() == menu.longValue()) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                throw new InvalidOperation(500, "菜单超出当前用户权限");
            }
        }
        Example example = new Example(RoleMenu.class);
        example.createCriteria().andEqualTo("role_id", role);
        roleMenuMapper.deleteByExample(example);
        int count = 0;
        for (Long menu : menus) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenu_id(menu);
            roleMenu.setRole_id(role);
            roleMenu.setCreate_time(new Date());
            count += roleMenuMapper.insert(roleMenu);
        }

        //清理权限
        Set<Long> back = new HashSet<>();
        StringBuilder backString = new StringBuilder();
        for (Menu oldMenu : oldMenus) {
            boolean have = false;
            for (Long menu : menus) {
                if (oldMenu.getId().longValue() == menu.longValue()) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                back.add(oldMenu.getId());
                backString.append(oldMenu.getId()).append(",");
            }
        }
        //有回收功能点
        if (!back.isEmpty()) {
            backString.deleteCharAt(backString.length() - 1);
            roleMapper.deleteRoleChildrenMenus(role, backString.toString());
        }
        return count == menus.size();
    }

    private List<RoleStruct> getRoleStructs(List<Role> roles) {
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
}
