package com.alone.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Deduction;
import com.alone.common.entity.DeductionApp;
import com.alone.common.entity.DeductionUser;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.BoxMapper;
import com.alone.core.mapper.DeductionAppMapper;
import com.alone.core.mapper.DeductionMapper;
import com.alone.core.mapper.DeductionUserMapper;
import com.alone.thrift.service.DeductionService;
import com.alone.thrift.struct.DeductionStruct;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.PageParamStruct;
import com.alone.thrift.struct.PageStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-16 下午10:26
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class DeductionServiceImpl implements DeductionService.Iface {

    @Autowired
    private DeductionMapper deductionMapper;

    @Autowired
    private DeductionAppMapper deductionAppMapper;

    @Autowired
    private DeductionUserMapper deductionUserMapper;

    @Override
    public long add(DeductionStruct bean, List<Long> apps) throws InvalidOperation, TException {
        Deduction deduction = new Deduction();
        Utils.java2Thrift(deduction, bean);
        deduction.setId(Utils.generateUUID());
        deduction.setStart_time(new Date(bean.getStart_time()));
        deduction.setEnd_time(new Date(bean.getEnd_time()));
        deduction.setCreate_time(new Date());
        deductionMapper.insertSelective(deduction);

        if (apps != null) {
            insertApp(apps, deduction);
        }
        return deduction.getId();
    }

    @Override
    public boolean update(DeductionStruct bean, List<Long> apps) throws InvalidOperation, TException {
        Deduction deduction = new Deduction();
        Utils.java2Thrift(deduction, bean);
        if (deduction.getId() == null || deduction.getId() <= 0)
            return false;
        if (!bean.isSetStatus())
            deduction.setStatus(null);
        if (bean.isSetStart_time()) {
            deduction.setStart_time(new Date(bean.getStart_time()));
        }
        if (bean.isSetEnd_time()) {
            deduction.setEnd_time(new Date(bean.getEnd_time()));
        }
        deductionMapper.updateByPrimaryKeySelective(deduction);

        if (apps != null) {
            insertApp(apps, deduction);
        }
        return true;
    }

    @Override
    public boolean setUsers(long id, List<Long> users) throws TException {
        Example del = new Example(DeductionUser.class);
        del.createCriteria().andEqualTo("deduction_id", id);
        deductionUserMapper.deleteByExample(del);
        for (Long user : users) {
            if (user != null && user > 0) {
                DeductionUser deductionUser = new DeductionUser();
                deductionUser.setDeduction_id(id);
                deductionUser.setUser_id(user);
                deductionUserMapper.insert(deductionUser);
            }
        }
        return true;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example delApp = new Example(DeductionApp.class);
        delApp.createCriteria().andEqualTo("deduction_id", id);
        deductionAppMapper.deleteByExample(delApp);
        Example delUser = new Example(DeductionUser.class);
        delUser.createCriteria().andEqualTo("deduction_id", id);
        deductionUserMapper.deleteByExample(delUser);
        if (deductionMapper.deleteByPrimaryKey(id) <= 0)
            throw new InvalidOperation(500, "操作失败");
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, deductionMapper);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String getUsers(long id) throws InvalidOperation, TException {
        return JSON.toJSONString(deductionMapper.getUsers(id));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String getApps(long id) throws InvalidOperation, TException {
        return JSON.toJSONString(deductionMapper.getApps(id));
    }

    private void insertApp(List<Long> apps, Deduction deduction) {
        Example del = new Example(DeductionApp.class);
        del.createCriteria().andEqualTo("deduction_id", deduction.getId());
        deductionAppMapper.deleteByExample(del);
        for (Long app : apps) {
            if (app != null && app > 0) {
                DeductionApp deductionApp = new DeductionApp();
                deductionApp.setDeduction_id(deduction.getId());
                deductionApp.setApp_id(app);
                deductionAppMapper.insert(deductionApp);
            }
        }
    }
}
