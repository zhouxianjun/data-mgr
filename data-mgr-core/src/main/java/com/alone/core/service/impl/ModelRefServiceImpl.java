package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.Model;
import com.alone.common.entity.ModelRef;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.ModelMapper;
import com.alone.core.mapper.ModelRefMapper;
import com.alone.thrift.service.ModelRefService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.ModelStruct;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public long add(ModelStruct bean, long ref, int type) throws InvalidOperation, TException {
        Example example = new Example(Model.class);
        example.createCriteria()
                .andEqualTo("brand_id", bean.getBrand_id())
                .andEqualTo("model_id", bean.getModel_id())
                .andEqualTo("version_id", bean.getVersion_id())
                .andEqualTo("base_version_id", bean.getBase_version_id());
        List<Model> models = modelMapper.selectByExample(example);
        Long model_id;
        if (models == null || models.size() <= 0) {
            Model model = new Model();
            model.setId(Utils.generateUUID());
            Utils.java2Thrift(model, bean);
            modelMapper.insert(model);
            model_id = model.getId();
        } else {
            model_id = models.get(0).getId();
        }

        ModelRef modelRef = new ModelRef();
        modelRef.setRef_id(ref);
        modelRef.setModel_id(model_id);
        modelRef.setType(type);
        modelRefMapper.insert(modelRef);
        return model_id;
    }

    @Override
    public boolean remove(long ref, long model, int type) throws InvalidOperation, TException {
        Example del = new Example(ModelRef.class);
        del.createCriteria().andEqualTo("ref_id", ref).andEqualTo("model_id", model).andEqualTo("type", type);
        return modelRefMapper.deleteByExample(del) > 0;
    }

    @Override
    public boolean removeModel(long id) throws InvalidOperation, TException {
        Example example = new Example(ModelRef.class);
        example.createCriteria().andEqualTo("model_id", id);
        if (modelRefMapper.selectCountByExample(example) > 0)
            throw new InvalidOperation(500, "请先删除关联");
        return modelMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, modelMapper);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listModelByPage(PageParamStruct page, long ref, int type) throws InvalidOperation, TException {
        Page<Model> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = modelRefMapper.listModelByPage(p, ref, type, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }
}
