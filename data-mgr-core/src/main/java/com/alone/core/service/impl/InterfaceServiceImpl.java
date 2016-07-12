package com.alone.core.service.impl;

import com.alone.common.entity.Interface;
import com.alone.common.util.Utils;
import com.alone.core.mapper.InterfaceMapper;
import com.alone.thrift.service.InterfaceService;
import com.alone.thrift.struct.InterfaceStruct;
import com.alone.thrift.struct.InvalidOperation;
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
 * @date 2016/7/12 16:40
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class InterfaceServiceImpl implements InterfaceService.Iface {
    @Autowired
    private InterfaceMapper interfaceMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<InterfaceStruct> interfaces() throws InvalidOperation, TException {
        List<Interface> list = interfaceMapper.selectAll();
        return getInterfaceStructs(list);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<InterfaceStruct> interfacesByUser(long user) throws InvalidOperation, TException {
        List<Interface> list = interfaceMapper.listByUser(user);
        return getInterfaceStructs(list);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<InterfaceStruct> interfacesBySetMenu(long user, long menu) throws InvalidOperation, TException {
        List<Interface> userList = interfaceMapper.listByUser(user);
        List<Interface> menuList = interfaceMapper.listByMenu(menu);
        List<InterfaceStruct> result = getInterfaceStructs(userList);
        for (InterfaceStruct userInterface : result) {
            boolean ow = false;
            for (Interface menuInterface : menuList) {
                if (menuInterface.getId() == userInterface.getId()) {
                    ow = true;
                    break;
                }
            }
            userInterface.setOw(ow);
        }
        return result;
    }

    @Override
    public long add(InterfaceStruct bean) throws InvalidOperation, TException {
        Interface i = new Interface();
        Utils.java2Thrift(i, bean);
        i.setId(Utils.generateUUID());
        i.setCreate_time(new Date());
        interfaceMapper.insertSelective(i);
        return i.getId();
    }

    @Override
    public boolean update(InterfaceStruct bean) throws InvalidOperation, TException {
        Interface i = new Interface();
        Utils.java2Thrift(i, bean);
        if (i.getId() == null || i.getId() <= 0)
            return false;
        return interfaceMapper.updateByPrimaryKeySelective(i) > 0;
    }

    private List<InterfaceStruct> getInterfaceStructs(List<Interface> list) {
        List<InterfaceStruct> result = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (Interface item : list) {
                result.add(Utils.java2Thrift(new InterfaceStruct()
                                .setCreate_time(item.getCreate_time().getTime())
                        , item));
            }
        }
        return result;
    }
}
