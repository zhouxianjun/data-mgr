package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.AppPackage;
import com.alone.common.entity.Package;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.AppPackageMapper;
import com.alone.core.mapper.PackageMapper;
import com.alone.thrift.service.PackageService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.PackageStruct;
import com.alone.thrift.struct.PageParamStruct;
import com.alone.thrift.struct.PageStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
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
public class PackageServiceIMpl implements PackageService.Iface {
    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private AppPackageMapper appPackageMapper;
    @Override
    public long add(PackageStruct bean) throws InvalidOperation, TException {
        Package aPackage = new Package();
        Utils.java2Thrift(aPackage, bean);
        aPackage.setId(Utils.generateUUID());
        aPackage.setCreate_time(new Date());
        aPackage.setPrice(BigDecimal.valueOf(bean.getPrice()));
        packageMapper.insertSelective(aPackage);
        return aPackage.getId();
    }

    @Override
    public boolean update(PackageStruct bean) throws InvalidOperation, TException {
        Package aPackage = new Package();
        Utils.java2Thrift(aPackage, bean);
        if (aPackage.getId() == null || aPackage.getId() <= 0)
            return false;
        aPackage.setPrice(BigDecimal.valueOf(bean.getPrice()));
        return packageMapper.updateByPrimaryKeySelective(aPackage) > 0;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example select = new Example(AppPackage.class);
        select.createCriteria().andEqualTo("package_id", id);
        int count = appPackageMapper.selectCountByExample(select);
        if (count > 0) {
            throw new InvalidOperation(500, "请先删除对应到应用包");
        }
        return packageMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public String allList() throws InvalidOperation, TException {
        return JSONArray.toJSONString(packageMapper.selectAll(), SerializerFeature.WriteMapNullValue);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, packageMapper);
    }

    @Override
    public PageStruct listPackageByPage(PageParamStruct page, long id) throws InvalidOperation, TException {
        Page<AppPackage> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = packageMapper.listPackageByPage(p, id, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }
}
