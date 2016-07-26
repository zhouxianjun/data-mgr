package com.alone.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.*;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.Util;
import com.alone.core.mapper.*;
import com.alone.thrift.service.ApiService;
import com.alone.thrift.service.AppActiveService;
import com.alone.thrift.service.UserService;
import com.alone.thrift.struct.*;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
public class ApiServiceImpl implements ApiService.Iface {

    @Autowired
    private UserService.Iface userService;

    @Autowired
    private UserRefMapper userRefMapper;

    @Autowired
    private BoxMapper boxMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private RequirePackageMapper requirePackageMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public boolean boxLogin(String username, String password, String box_id) throws InvalidOperation, TException {
        UserStruct struct = userService.login(username, password);
        if (struct.getId() <= 0)
            return false;
        Box box = userRefMapper.getBox(struct.getId(), box_id);
        return box != null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String checkBoxVersion(String box_id, int version_code) throws InvalidOperation, TException {
        Map<String, Object> result = new HashMap<>();
        Version version = boxMapper.getNewVersion(box_id);
        if (version != null && version.getVersion_code() != version_code) {
            Resources resources = resourcesMapper.selectByPrimaryKey(version.getResource());
            result.put("version", version.getVersion());
            result.put("version_code", version.getVersion_code());
            result.put("desc", version.getDesc());
            result.put("md5", resources.getMd5());
            result.put("name", resources.getName());
            result.put("size", resources.getSize());
        }
        return JSONObject.toJSONString(result);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String getBoxResourcesList(long user) throws InvalidOperation, TException {
        Map<String, Object> result = new HashMap<>();
        result.put("mandatory", getMandatory(user));
        return JSONObject.toJSONString(result);
    }

    @Override
    public String uploadBrush(String box_id, String data) throws InvalidOperation, TException {
        return null;
    }

    private List<Map<String, Object>> getMandatory(long user) {
        List<Map<String, Object>> mandatory = new ArrayList<>();
        List<RequirePackage> requirePackageList = requirePackageMapper.allList(user);
        if (requirePackageList != null && requirePackageList.size() > 0) {
            for (RequirePackage requirePackage : requirePackageList) {
                Map<String, Object> requireMap = new HashMap<>();
                requireMap.put("mandatory_id", requirePackage.getId());
                requireMap.put("mandatory_name", requirePackage.getName());
                requireMap.put("android_version", requirePackage.getAndroid_version());
                requireMap.put("is_root", requirePackage.getRoot());
                mandatory.add(requireMap);
            }
        }
        return mandatory;
    }
}
