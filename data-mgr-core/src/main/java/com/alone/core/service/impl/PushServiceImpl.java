package com.alone.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.ClientPush;
import com.alone.common.entity.Push;
import com.alone.common.entity.Resources;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.ClientPushMapper;
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
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
    @Autowired
    private ClientPushMapper clientPushMapper;

    @Override
    public long add(PushStruct bean) throws InvalidOperation, TException {
        Push push = new Push();
        Utils.java2Thrift(push, bean);
        push.setDeduct(BigDecimal.valueOf(bean.getDeduct()));
        push.setId(Utils.generateUUID());
        push.setCreate_time(new Date());
        push.setStart_time(new Date(bean.getStart_time()));
        push.setEnd_time(new Date(bean.getEnd_time()));

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
        if (bean.isSetStart_time()) {
            push.setStart_time(new Date(bean.getStart_time()));
        }
        if (bean.isSetEnd_time()) {
            push.setEnd_time(new Date(bean.getEnd_time()));
        }
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

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String listUnRead(long user, String client_code, int type, String url) throws InvalidOperation, TException {
        List<HashMap<String, Object>> list = pushMapper.getUnRead(user, client_code, type);
        if (list == null) return JSON.toJSONString(Collections.EMPTY_LIST);
        for (HashMap<String, Object> map : list) {
            map.remove("user_id");
            if (map.containsKey("img_md5")) {
                map.put("img_url", url + map.get("img_md5"));
            }
            if (map.containsKey("app_md5")) {
                map.put("app_url", url + map.get("app_md5"));
            }
        }
        return JSON.toJSONString(list);
    }

    @Override
    public boolean readPush(long user, String client_code, int type, long push) throws InvalidOperation, TException {
        ClientPush select = new ClientPush();
        select.setUser_id(user);
        select.setClient_code(client_code);
        select.setClient_type(type);
        ClientPush db = clientPushMapper.selectOne(select);
        if (db != null && db.getPush_id() >= push)
            return true;
        pushMapper.readPush(user, client_code, type, push);
        return true;
    }
}
