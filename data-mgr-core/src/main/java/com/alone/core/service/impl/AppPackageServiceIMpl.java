package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.App;
import com.alone.common.entity.AppPackage;
import com.alone.common.entity.PackageApp;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppPackageMapper;
import com.alone.core.mapper.PackageAppMapper;
import com.alone.thrift.service.AppPackageService;
import com.alone.thrift.struct.AppPackageStruct;
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
 * @date 16-7-23 上午9:48
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class AppPackageServiceIMpl implements AppPackageService.Iface {
    @Autowired
    private AppPackageMapper appPackageMapper;
    @Autowired
    private PackageAppMapper packageAppMapper;

    @Override
    public long add(AppPackageStruct bean) throws InvalidOperation, TException {
        AppPackage aPackage = new AppPackage();
        Utils.java2Thrift(aPackage, bean);
        aPackage.setId(Utils.generateUUID());
        aPackage.setCreate_time(new Date());
        appPackageMapper.insertSelective(aPackage);

        Util.checkApps(bean.getPre(), bean.getInstall(), aPackage.getId(), packageAppMapper);
        return aPackage.getId();
    }

    @Override
    public boolean update(AppPackageStruct bean) throws InvalidOperation, TException {
        AppPackage aPackage = new AppPackage();
        Utils.java2Thrift(aPackage, bean);
        if (aPackage.getId() == null || aPackage.getId() <= 0)
            return false;
        Util.checkApps(bean.getPre(), bean.getInstall(), aPackage.getId(), packageAppMapper);
        return appPackageMapper.updateByPrimaryKeySelective(aPackage) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example del = new Example(PackageApp.class);
        del.createCriteria().andEqualTo("app_package_id", id);
        packageAppMapper.deleteByExample(del);
        if (appPackageMapper.deleteByPrimaryKey(id) <= 0) {
            throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    @Override
    public boolean removeApp(long id, long app, int type) throws InvalidOperation, TException {
        Example del = new Example(PackageApp.class);
        del.createCriteria().andEqualTo("app_package_id", id).andEqualTo("app_id", app).andEqualTo("type", type);
        return packageAppMapper.deleteByExample(del) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, appPackageMapper);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listAppByPage(PageParamStruct page, int type, long id) throws InvalidOperation, TException {
        Page<App> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = appPackageMapper.listAppByPage(p, id, type, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    @Override
    public String appAllList(long id, int type) throws InvalidOperation, TException {
        List<App> list = appPackageMapper.appAllList(id, type > 0 ? type : null);
        return JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }
}
