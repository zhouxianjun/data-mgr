package com.alone.core.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Menu;
import com.alone.common.entity.MenuInterface;
import com.alone.common.entity.RoleMenu;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.mapper.MenuInterfaceMapper;
import com.alone.core.mapper.MenuMapper;
import com.alone.core.mapper.RoleMenuMapper;
import com.alone.thrift.service.MenuService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.MenuStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-10 上午9:44
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class MenuServiceImpl implements MenuService.Iface {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuInterfaceMapper menuInterfaceMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<MenuStruct> menus() throws TException {
        List<Menu> menus = menuMapper.selectAll();
        return getMenuStructs(menus);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public List<MenuStruct> menusByUser(long user) throws TException {
        List<Menu> menus = menuMapper.listByUser(user, true);
        return getMenuStructs(menus);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public List<MenuStruct> menusBySetRole(long user, long role) throws TException {
        List<Menu> userMenus = menuMapper.listByUser(user, null);
        List<Menu> roleMenus = menuMapper.listByRole(role);
        List<MenuStruct> result = getMenuStructs(userMenus);
        for (MenuStruct userMenu : result) {
            boolean ow = false;
            for (Menu roleMenu : roleMenus) {
                if (roleMenu.getId() == userMenu.getId()) {
                    ow = true;
                    break;
                }
            }
            userMenu.setOw(ow);
        }
        return result;
    }

    @Override
    public long add(MenuStruct menu, long user) throws TException {
        if (user != 1) throw new InvalidOperation(500, "没有改接口的操作权限");
        String pids = "0";
        if (menu.getPid() > 0) {
            Menu parent = menuMapper.selectByPrimaryKey(menu.getPid());
            pids = StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids();
        }
        Menu m = new Menu();
        Utils.java2Thrift(m, menu);
        m.setId(Utils.generateUUID());
        m.setCreate_time(new Date());
        m.setPids(pids);
        menuMapper.insertSelective(m);
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenu_id(m.getId());
        roleMenu.setRole_id(1L);
        roleMenu.setCreate_time(new Date());
        roleMenuMapper.insert(roleMenu);
        return m.getId();
    }

    @Override
    public boolean update(MenuStruct menu) throws TException {
        String pids = null;
        if (menu.getPid() > 0) {
            Menu parent = menuMapper.selectByPrimaryKey(menu.getPid());
            pids = StringUtils.isEmpty(parent.getPids()) ? String.valueOf(parent.getId()) : parent.getId() + "," + parent.getPids();
        }
        Menu m = menuMapper.selectByPrimaryKey(menu.getId());
        if (m == null)
            throw new InvalidOperation(500, "菜单不存在");
        Utils.java2Thrift(m, menu);
        if (m.getId() == null || m.getId() <= 0)
            return false;
        if (menu.isSetStatus()) {
            menuMapper.updateChildStatus(m.getId(), m.getStatus());
        }
        m.setPids(pids);
        return menuMapper.updateByPrimaryKeySelective(m) > 0;
    }

    @Override
    public boolean delMenu(long id) throws TException {
        menuMapper.deleteMenu(id);
        menuMapper.deleteMenuInterface(id);
        return true;
    }

    @Override
    public boolean setInterfaces(long menu, long user, List<Long> interfaces) throws TException {
        Example example = new Example(MenuInterface.class);
        example.createCriteria().andEqualTo("menu_id", menu);
        menuInterfaceMapper.deleteByExample(example);
        int count = 0;
        for (Long anInterface : interfaces) {
            MenuInterface menuInterface = new MenuInterface();
            menuInterface.setMenu_id(menu);
            menuInterface.setInterface_id(anInterface);
            menuInterface.setCreate_time(new Date());
            count += menuInterfaceMapper.insert(menuInterface);
        }
        return count == interfaces.size();
    }

    private List<MenuStruct> getMenuStructs(List<Menu> menus) {
        List<MenuStruct> result = new ArrayList<>();
        if (menus != null && !menus.isEmpty()) {
            for (Menu menu : menus) {
                result.add(Utils.java2Thrift(new MenuStruct()
                                .setCreate_time(menu.getCreate_time().getTime())
                        , menu));
            }
        }
        return result;
    }
}
