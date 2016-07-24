package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.MobileBaseVersion;
import com.alone.common.entity.MobileBrand;
import com.alone.common.entity.MobileModel;
import com.alone.common.entity.MobileVersion;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.MobileBaseVersionMapper;
import com.alone.core.mapper.MobileBrandMapper;
import com.alone.core.mapper.MobileModelMapper;
import com.alone.core.mapper.MobileVersionMapper;
import com.alone.thrift.service.ModelMgrService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.PageParamStruct;
import com.alone.thrift.struct.PageStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午10:23
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class ModelMgrServiceImpl implements ModelMgrService.Iface {
    @Autowired
    private MobileBrandMapper mobileBrandMapper;
    @Autowired
    private MobileModelMapper mobileModelMapper;
    @Autowired
    private MobileVersionMapper mobileVersionMapper;
    @Autowired
    private MobileBaseVersionMapper mobileBaseVersionMapper;
    @Override
    public long addBrand(String name) throws InvalidOperation, TException {
        MobileBrand brand = new MobileBrand();
        brand.setId(Utils.generateUUID());
        brand.setName(name);
        mobileBrandMapper.insert(brand);
        return brand.getId();
    }

    @Override
    public boolean removeBrand(long id) throws InvalidOperation, TException {
        Example selectModel = new Example(MobileModel.class);
        selectModel.createCriteria().andEqualTo("brand_id", id);
        int count = mobileModelMapper.selectCountByExample(selectModel);
        if (count > 0) throw new InvalidOperation(500, "请先删除机型");
        return mobileBrandMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public long addModel(String name, long brand) throws InvalidOperation, TException {
        MobileModel model = new MobileModel();
        model.setId(Utils.generateUUID());
        model.setBrand_id(brand);
        model.setName(name);
        mobileModelMapper.insert(model);
        return model.getId();
    }

    @Override
    public boolean removeModel(long id) throws InvalidOperation, TException {
        Example select = new Example(MobileVersion.class);
        select.createCriteria().andEqualTo("model_id", id);
        int count = mobileVersionMapper.selectCountByExample(select);
        if (count > 0) throw new InvalidOperation(500, "请先删除版本");
        return mobileModelMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public long addVersion(String name, long model) throws InvalidOperation, TException {
        MobileVersion version = new MobileVersion();
        version.setId(Utils.generateUUID());
        version.setName(name);
        version.setModel_id(model);
        mobileVersionMapper.insert(version);
        return version.getId();
    }

    @Override
    public boolean removeVersion(long id) throws InvalidOperation, TException {
        Example select = new Example(MobileBaseVersion.class);
        select.createCriteria().andEqualTo("version_id", id);
        int count = mobileBaseVersionMapper.selectCountByExample(select);
        if (count > 0) throw new InvalidOperation(500, "请先删除基带版本");
        return mobileVersionMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public long addBaseVersion(String name, long version) throws InvalidOperation, TException {
        MobileBaseVersion baseVersion = new MobileBaseVersion();
        baseVersion.setId(Utils.generateUUID());
        baseVersion.setName(name);
        baseVersion.setVersion_id(version);
        mobileBaseVersionMapper.insert(baseVersion);
        return baseVersion.getId();
    }

    @Override
    public boolean removeBaseVersion(long id) throws InvalidOperation, TException {
        return mobileBaseVersionMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public PageStruct brandByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, mobileBrandMapper);
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public PageStruct modelByPage(PageParamStruct page, long brand) throws InvalidOperation, TException {
        Page p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = mobileModelMapper.listByPageByBrand(p, brand, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public PageStruct versionByPage(PageParamStruct page, long model) throws InvalidOperation, TException {
        Page p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = mobileVersionMapper.listByPageByModel(p, model, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public PageStruct baseVersionByPage(PageParamStruct page, long version) throws InvalidOperation, TException {
        Page p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = mobileBaseVersionMapper.listByPageByVersion(p, version, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public String brandList() throws InvalidOperation, TException {
        List<MobileBrand> list = mobileBrandMapper.selectAll();
        return JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public String modelList(long brand) throws InvalidOperation, TException {
        List<MobileModel> list;
        if (brand > 0) {
            Example select = new Example(MobileModel.class);
            select.createCriteria().andEqualTo("brand_id", brand);
            list = mobileModelMapper.selectByExample(select);
        } else {
            list = mobileModelMapper.selectAll();
        }
        return JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public String versionList(long model) throws InvalidOperation, TException {
        List<MobileVersion> list;
        if (model > 0) {
            Example select = new Example(MobileVersion.class);
            select.createCriteria().andEqualTo("model_id", model);
            list = mobileVersionMapper.selectByExample(select);
        } else {
            list = mobileVersionMapper.selectAll();
        }
        return JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }

    @Override
    @DataSource(DataSourceType.READ)
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public String baseVersionList(long version) throws InvalidOperation, TException {
        List<MobileBaseVersion> list;
        if (version > 0) {
            Example select = new Example(MobileBaseVersion.class);
            select.createCriteria().andEqualTo("version_id", version);
            list = mobileBaseVersionMapper.selectByExample(select);
        } else {
            list = mobileBaseVersionMapper.selectAll();
        }
        return JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue);
    }
}
