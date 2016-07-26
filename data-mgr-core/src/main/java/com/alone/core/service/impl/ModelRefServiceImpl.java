package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.ModelRef;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.mapper.ModelRefMapper;
import com.alone.thrift.service.ModelRefService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.ModelRefStruct;
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
 * @date 16-7-24 下午12:14
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class ModelRefServiceImpl implements ModelRefService.Iface {
    @Autowired
    private ModelRefMapper modelRefMapper;

    @Override
    public long add(ModelRefStruct bean, long ref, int type) throws InvalidOperation, TException {
        Example example = new Example(ModelRef.class);
        example.createCriteria()
                .andEqualTo("brand_id", bean.getBrand_id())
                .andEqualTo("model_id", bean.getModel_id())
                .andEqualTo("version_id", bean.getVersion_id())
                .andEqualTo("base_version_id", bean.getBase_version_id())
                .andEqualTo("ref_id", ref)
                .andEqualTo("type", type);
        if (modelRefMapper.selectCountByExample(example) > 0) {
            throw new InvalidOperation(500, "已经存在");
        }
        ModelRef rootModel = new ModelRef();
        Utils.java2Thrift(rootModel, bean);
        rootModel.setId(Utils.generateUUID());
        rootModel.setRef_id(ref);
        rootModel.setType(type);
        modelRefMapper.insert(rootModel);
        return rootModel.getId();
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        return modelRefMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listModelByPage(PageParamStruct page, long ref, int type) throws InvalidOperation, TException {
        Page<ModelRef> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = modelRefMapper.listModelByPage(p, ref, type, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }
}
