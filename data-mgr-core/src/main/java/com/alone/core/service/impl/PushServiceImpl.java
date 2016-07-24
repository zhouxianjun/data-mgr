package com.alone.core.service.impl;

import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.Push;
import com.alone.common.entity.Resources;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.PushMapper;
import com.alone.core.mapper.ResourcesMapper;
import com.alone.thrift.service.PushService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午12:14
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class PushServiceImpl implements PushService.Iface {
    @Autowired
    private PushMapper pushMapper;
    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public long add(PushStruct bean) throws InvalidOperation, TException {
        Push push = new Push();
        Utils.java2Thrift(push, bean);
        push.setDeduct(BigDecimal.valueOf(bean.getDeduct()));
        push.setId(Utils.generateUUID());
        push.setCreate_time(new Date());

        ResourcesStruct img = bean.getImg();
        Long img_id = Util.changeAppFile(img, resourcesMapper);
        if (img_id != null)
            push.setImg_resources_id(img_id);
        ResourcesStruct app = bean.getApp();
        Long app_id = Util.changeAppFile(app, resourcesMapper);
        if (app_id != null)
            push.setApp_resources_id(app_id);

        push.setStatus(1);
        if (pushMapper.insertSelective(push) <= 0) {
            throw new InvalidOperation(500, "操作失败");
        }
        return push.getId();
    }

    @Override
    public boolean update(PushStruct bean) throws InvalidOperation, TException {
        Push push = new Push();
        Utils.java2Thrift(push, bean);
        if (push.getId() == null || push.getId() <= 0)
            throw new InvalidOperation(500, "非法操作");
        push.setCreate_time(null);
        push.setApp_resources_id(null);
        push.setImg_resources_id(null);
        push.setUser_id(null);
        if (!bean.isSetClient_type())
            push.setClient_type(null);
        if (!bean.isSetType())
            push.setType(null);
        if (!bean.isSetStatus())
            push.setStatus(null);
        return pushMapper.updateByPrimaryKeySelective(push) > 0;
    }

    @Override
    public boolean changeImg(ResourcesStruct bean, long id) throws InvalidOperation, TException {
        Push push = pushMapper.selectByPrimaryKey(id);
        if (push == null)
            throw new InvalidOperation(500, "非法操作");
        Long rid = Util.changeAppFile(bean, resourcesMapper);
        if (rid == null)
            return false;
        push.setImg_resources_id(rid);
        return pushMapper.updateByPrimaryKeySelective(push) > 0;
    }

    @Override
    public boolean changeApp(ResourcesStruct bean, long id) throws InvalidOperation, TException {
        Push push = pushMapper.selectByPrimaryKey(id);
        if (push == null)
            throw new InvalidOperation(500, "非法操作");
        Long rid = Util.changeAppFile(bean, resourcesMapper);
        if (rid == null)
            return false;
        push.setApp_resources_id(rid);
        return pushMapper.updateByPrimaryKeySelective(push) > 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public PageStruct listByPage(PageParamStruct page) throws InvalidOperation, TException {
        return Util.buildListPage(page, pushMapper);
    }
}
