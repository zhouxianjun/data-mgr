package com.alone.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.*;
import com.alone.common.mybatis.DataSource;
import com.alone.core.mapper.*;
import com.alone.thrift.service.ApiService;
import com.alone.thrift.service.UserService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.UserStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private AppPackageMapper appPackageMapper;

    @Autowired
    private RootConfigMapper rootConfigMapper;

    @Autowired
    private InstallActiveMapper installActiveMapper;

    @Autowired
    private AppWhiteMapper appWhiteMapper;

    @Autowired
    private ModelRefMapper modelRefMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public long boxLogin(String username, String password, String box_id) throws InvalidOperation, TException {
        UserStruct struct = userService.login(username, password);
        if (struct.getId() <= 0)
            return 0;
        Box box = userRefMapper.getBox(struct.getId(), box_id);
        return box == null ? 0 : struct.getId();
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
        result.put("require_package", getRequirePackage(user));
        result.put("app_package", getAppPackage(user));
        result.put("all_roots", getRootConfig(user));
        result.put("install_active", getInstallActive(user));
        result.put("models", getModel(user));
        return JSONObject.toJSONString(result);
    }

    @Override
    public String uploadBrush(String box_id, String data) throws InvalidOperation, TException {
        JSONObject jsonData = JSON.parseObject(data);
        jsonData.getJSONObject("mobile");
        return null;
    }

    private List<HashMap<String, Object>> getRootConfig(long user) {
        List<HashMap<String, Object>> rootList = rootConfigMapper.listAllAndResources();
        if (rootList != null) {
            filterMoreInfo(rootList);
        }
        return rootList;
    }

    private List<HashMap<String, Object>> getModel(long user) {
        List<HashMap<String, Object>> modelList = modelRefMapper.selectAllModel();
        if (modelList != null) {
            for (HashMap<String, Object> map : modelList) {
                Map<String, Object> stepMap = new HashMap<>();
                List<HashMap<String, Object>> appWhiteList = appWhiteMapper.allAndResourcesListByModel(
                        user,
                        (Long) map.get("brand_id"),
                        (Long) map.get("model_id"),
                        (Long) map.get("version_id"),
                        (Long) map.get("base_version_id"));
                filterMoreInfo(appWhiteList);
                stepMap.put("roster", appWhiteList);
                List<HashMap<String, Object>> rootList = rootConfigMapper.allAndResourcesListByModel(
                        (Long) map.get("brand_id"),
                        (Long) map.get("model_id"),
                        (Long) map.get("version_id"),
                        (Long) map.get("base_version_id"));
                filterMoreInfo(rootList);
                stepMap.put("root", rootList);
                map.put("step", stepMap);
            }
        }
        return modelList;
    }

    private List<InstallActive> getInstallActive(long user) {
        List<InstallActive> activeList = installActiveMapper.allList(user);
        if (activeList != null) {
            for (InstallActive active : activeList) {
                active.setCreate_time(null);
                active.setMemo(null);
            }
        }
        return activeList;
    }

    private List<Map<String, Object>> getAppPackage(long user) {
        List<Map<String, Object>> appList = new ArrayList<>();
        List<AppPackage> appPackageList = appPackageMapper.allList(user);
        if (appPackageList != null && appPackageList.size() > 0) {
            for (AppPackage appPackage : appPackageList) {
                Map<String, Object> appMap = new HashMap<>();
                appMap.put("id", appPackage.getId());
                appMap.put("name", appPackage.getName());
                appMap.put("is_root", appPackage.getRoot());
                appList.add(appMap);

                List<HashMap<String, Object>> apps = appPackageMapper.appAndResourcesAllList(appPackage.getId(), null);
                if (apps != null) {
                    filterMoreInfo(apps);
                }
                appMap.put("apps", apps);
            }
        }
        return appList;
    }

    private List<Map<String, Object>> getRequirePackage(long user) {
        List<Map<String, Object>> requireList = new ArrayList<>();
        List<RequirePackage> requirePackageList = requirePackageMapper.allList(user);
        if (requirePackageList != null && requirePackageList.size() > 0) {
            for (RequirePackage requirePackage : requirePackageList) {
                Map<String, Object> requireMap = new HashMap<>();
                requireMap.put("id", requirePackage.getId());
                requireMap.put("name", requirePackage.getName());
                requireMap.put("android_version", requirePackage.getAndroid_version());
                requireMap.put("is_root", requirePackage.getRoot());
                requireList.add(requireMap);

                List<HashMap<String, Object>> apps = requirePackageMapper.appAndResourcesAllList(requirePackage.getId(), null);
                if (apps != null) {
                    filterMoreInfo(apps);
                }
                requireMap.put("apps", apps);
            }
        }
        return requireList;
    }

    private void filterMoreInfo(List<HashMap<String, Object>> apps) {
        for (Map<String, Object> app : apps) {
            app.remove("memo");
            app.remove("resources_id");
            app.remove("create_time");
        }
    }
}
