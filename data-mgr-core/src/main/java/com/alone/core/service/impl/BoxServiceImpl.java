package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Box;
import com.alone.common.entity.Resources;
import com.alone.common.entity.UserRef;
import com.alone.common.entity.Version;
import com.alone.common.enums.RefType;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.BoxMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.UserRefMapper;
import com.alone.core.mapper.VersionMapper;
import com.alone.thrift.service.BoxService;
import com.alone.thrift.struct.*;
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
 * @date 16-7-16 下午10:26
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class BoxServiceImpl implements BoxService.Iface {

    @Autowired
    private BoxMapper boxMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private VersionMapper versionMapper;

    @Autowired
    private UserRefMapper userRefMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct boxByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, boxMapper);
    }

    @Override
    public long add(BoxStruct bean) throws InvalidOperation, TException {
        Box select = new Box();
        select.setBox_id(bean.getBox_id());
        select = boxMapper.selectOne(select);
        if (select != null) {
            throw new InvalidOperation(500, "该盒子已存在");
        }
        Box box = new Box();
        Utils.java2Thrift(box, bean);
        box.setId(Utils.generateUUID());
        box.setCreate_time(new Date());
        box.setUpdate_time(new Date());
        boxMapper.insertSelective(box);

        UserRef ref = new UserRef();
        ref.setUser_id(1L);
        ref.setRef_id(box.getId());
        ref.setType(RefType.BOX.getVal());
        userRefMapper.insert(ref);
        return box.getId();
    }

    @Override
    public boolean update(BoxStruct bean) throws InvalidOperation, TException {
        Box box = new Box();
        Utils.java2Thrift(box, bean);
        if (box.getId() == null || box.getId() <= 0)
            return false;
        box.setUpdate_time(new Date());
        return boxMapper.updateByPrimaryKeySelective(box) > 0;
    }

    @Override
    public VersionStruct updateVersion(ResourcesStruct resources, VersionStruct version, long id) throws InvalidOperation, TException {
        Box box = boxMapper.selectByPrimaryKey(id);
        if (box == null) throw new InvalidOperation(500, "盒子不存在");
        Resources r = new Resources();
        Utils.java2Thrift(r, resources);
        r.setId(Utils.generateUUID());
        r.setCreate_time(new Date());
        resourcesMapper.insertSelective(r);
        Version v = new Version();
        Utils.java2Thrift(v, version);
        v.setId(Utils.generateUUID());
        v.setCreate_time(new Date());
        v.setResource(r.getId());
        versionMapper.insertSelective(v);
        box.setVersion_id(v.getId());
        boxMapper.updateByPrimaryKeySelective(box);
        Utils.java2Thrift(version, v);
        return version;
    }

    @Override
    public boolean remove(long id) throws InvalidOperation, TException {
        Example del = new Example(UserRef.class);
        del.createCriteria().andEqualTo("user_id", 1L).andEqualTo("ref_id", id).andEqualTo("type", RefType.BOX.getVal());
        userRefMapper.deleteByExample(del);
        if (boxMapper.deleteByPrimaryKey(id) <= 0)
            throw new InvalidOperation(500, "操作失败");
        return true;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String allList(long user) throws InvalidOperation, TException {
        if (user > 0) {
            return JSONArray.toJSONString(boxMapper.allList(user), SerializerFeature.WriteMapNullValue);
        }
        return JSONArray.toJSONString(boxMapper.selectAll(), SerializerFeature.WriteMapNullValue);
    }
}
