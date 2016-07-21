package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Resources;
import com.alone.common.entity.Version;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.core.mapper.VersionMapper;
import com.alone.thrift.service.ResourcesService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.ResourcesStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public ResourcesStruct getByMD5(String md5) throws InvalidOperation, TException {
        Resources resources = new Resources();
        resources.setMd5(md5);
        resources = resourcesMapper.selectOne(resources);
        return resources == null ? new ResourcesStruct() : Utils.java2Thrift(new ResourcesStruct().setCreate_time(resources.getCreate_time().getTime()), resources);
    }
}
