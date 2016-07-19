package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.App;
import com.alone.common.entity.AppActive;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppActiveMapper;
import com.alone.core.mapper.AppMapper;
import com.alone.thrift.service.AppActiveService;
import com.alone.thrift.struct.AppActiveStruct;
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

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class AppActiveServiceImpl implements AppActiveService.Iface {

    @Autowired
    private AppActiveMapper appActiveMapper;

    @Autowired
    private AppMapper appMapper;
    
    @Override
    public long add(AppActiveStruct bean) throws InvalidOperation, TException {
        AppActive appActive = new AppActive();
        Utils.java2Thrift(appActive, bean);
        appActive.setId(Utils.generateUUID());
        appActive.setCreate_time(new Date());
        appActiveMapper.insertSelective(appActive);
        return appActive.getId();
    }

    @Override
    public boolean update(AppActiveStruct bean) throws InvalidOperation, TException {
        AppActive appActive = new AppActive();
        Utils.java2Thrift(appActive, bean);
        if (appActive.getId() == null || appActive.getId() <= 0)
            return false;
        return appActiveMapper.updateByPrimaryKeySelective(appActive) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example example = new Example(App.class);
        example.createCriteria().andEqualTo("active_id", id);
        App app = new App();
        app.setActive_id(null);
        appMapper.updateByExample(app, example);

        boolean isDel = appActiveMapper.deleteByPrimaryKey(id) > 0;
        if (!isDel) {
            throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, appActiveMapper);
    }
}
