package com.alone.core.service.impl;

import com.alone.common.entity.Menu;
import com.alone.common.util.Utils;
import com.alone.core.mapper.InterfaceMapper;
import com.alone.core.mapper.MenuMapper;
import com.alone.thrift.service.MenuService;
import com.alone.thrift.struct.MenuStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    private InterfaceMapper interfaceMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<MenuStruct> menus() throws TException {
        List<Menu> menus = menuMapper.select(null);
        return getMenuStructs(menus);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<MenuStruct> menusByUser(long user) throws TException {
        List<Menu> menus = menuMapper.listByUser(user);
        return getMenuStructs(menus);
    }

    @Override
    public long add(MenuStruct menu) throws TException {
        Menu m = new Menu();
        Utils.java2Thrift(m, menu);
        m.setId(Utils.generateUUID());
        m.setStatus(Boolean.TRUE);
        m.setCreate_time(new Date());
        menuMapper.insertSelective(m);
        return m.getId();
    }

    @Override
    public boolean update(MenuStruct menu) throws TException {
        Menu m = new Menu();
        Utils.java2Thrift(m, menu);
        if (m.getId() == null || m.getId() <= 0)
            return false;
        menuMapper.updateByPrimaryKeySelective(m);
        return true;
    }

    @Override
    public boolean delMenu(long id) throws TException {

        return false;
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
