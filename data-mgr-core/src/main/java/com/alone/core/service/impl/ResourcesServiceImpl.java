package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.dto.Page;
import com.alone.common.entity.Box;
import com.alone.common.entity.Resources;
import com.alone.common.entity.Version;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.mapper.BoxMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.VersionMapper;
import com.alone.thrift.service.BoxService;
import com.alone.thrift.service.ResourcesService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-16 下午10:26
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class ResourcesServiceImpl implements ResourcesService.Iface {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private VersionMapper versionMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public ResourcesStruct getByVersion(long id) throws InvalidOperation, TException {
        Version version = versionMapper.selectByPrimaryKey(id);
        Resources resources = resourcesMapper.selectByPrimaryKey(version.getResource());
        return Utils.java2Thrift(new ResourcesStruct().setCreate_time(resources.getCreate_time().getTime()), resources);
    }
}
