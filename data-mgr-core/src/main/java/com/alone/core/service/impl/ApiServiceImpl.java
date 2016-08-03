package com.alone.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.DataSourceType;
import com.alone.common.entity.*;
import com.alone.common.mybatis.DataSource;
import com.alone.common.util.Utils;
import com.alone.core.mapper.*;
import com.alone.thrift.service.ApiService;
import com.alone.thrift.service.UserService;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.UserStruct;
import com.gary.thriftext.spring.annotation.ThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:37
 */
@ThriftService
@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Slf4j
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

    @Autowired
    private MobileInstallMapper mobileInstallMapper;

    @Autowired
    private AppInstallMapper appInstallMapper;

    @Autowired
    private AppActiveDataMapper appActiveDataMapper;

    @Autowired
    private MobileActiveDataMapper mobileActiveDataMapper;

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @DataSource(DataSourceType.READ)
    public String boxLogin(String username, String password, String box_id) throws InvalidOperation, TException {
        String struct = userService.login(username, password);
        JSONObject object = JSON.parseObject(struct);
        if (object.get("id") == null || object.getLong("id") <= 0)
            return null;
        Box box = userRefMapper.getBox(object.getLong("id"), box_id);
        if (box == null)
            return null;
        object.put("box_id", box.getId());
        return object.toString();
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
    public String getBoxResourcesList(long user, String url) throws InvalidOperation, TException {
        Map<String, Object> result = new HashMap<>();
        result.put("require_package", getRequirePackage(user, url));
        result.put("app_package", getAppPackage(user, url));
        result.put("all_roots", getRootConfig(url));
        result.put("install_active", getInstallActive(user));
        result.put("models", getModel(user, url));
        return JSONObject.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public boolean uploadBrush(String box_id, String data, long user, String ip) throws InvalidOperation, TException {
        Box b = new Box();
        b.setBox_id(box_id);
        Box dbBox = boxMapper.selectOne(b);
        if (dbBox == null) return false;

        JSONObject jsonData = JSON.parseObject(data);
        JSONObject mobile = jsonData.getJSONObject("mobile_info");
        Integer fail_step = jsonData.getInteger("fail_step");
        JSONObject applications = jsonData.getJSONObject("applications");
        Long application_id = applications.getLong("application_id");
        Resources logResources = null;
        if (fail_step != null && fail_step > 0) {
            JSONObject log_file = jsonData.getJSONObject("log_file");
            if (log_file != null) {
                logResources = parseLogFile(log_file);
            }
        }

        HashMap<String, Object> model = modelRefMapper.selectModelByName(
                mobile.get("brand"),
                mobile.get("model"),
                mobile.get("android_version"),
                mobile.get("baseband_version"));

        LogInfo logInfo = new LogInfo();
        logInfo.setId(Utils.generateUUID());
        logInfo.setBox_id(dbBox.getId());
        logInfo.setImei(mobile.getString("imei"));
        logInfo.setMemo(jsonData.getString("description"));
        logInfo.setFail_code(fail_step);
        logInfo.setResult(jsonData.getString("brush_result"));
        logInfo.setBrand_id((Long) model.get("brand_id"));
        logInfo.setModel_id((Long) model.get("model_id"));
        logInfo.setVersion_id((Long) model.get("version_id"));
        logInfo.setBase_version_id((Long) model.get("base_version_id"));
        logInfo.setIp(ip);
        logInfo.setLocal_ip(jsonData.getString("local_ip"));
        logInfo.setUser_id(user);
        if (logResources != null)
            logInfo.setLog_resources_id(logResources.getId());

        int app_num = 0; int success_num = 0;
        if (jsonData.get("app_num") != null) {
            app_num = jsonData.getInteger("app_num");
        }
        if (jsonData.get("success_num") != null) {
            success_num = jsonData.getInteger("success_num");
        }

        Double rate = 0.0D;
        int installapps = 0;
        if (app_num != 0) {
            rate = (double) success_num / app_num;
        } else {
            JSONArray app = applications.getJSONArray("app");
            if ((app != null) && (app.size() > 0)) {
                for (int i = 0; i < app.size(); i++) {
                    JSONObject a = app.getJSONObject(i);
                    Integer install_result = a.getInteger("install_result");
                    if (install_result == 0) {
                        installapps++;
                    }
                }
                rate = (double) installapps / app.size();
            } else {
                rate = 0.0D;
            }
        }

        logInfo.setSuccess_rate((int) (rate * 100));
        logInfo.setStart_time(parseDate(jsonData.getString("startTime")));
        logInfo.setEnd_time(parseDate(jsonData.getString("stopTime")));
        logInfo.setCreate_time(new Date());

        logInfoMapper.insertSelective(logInfo);

        MobileInstall install = new MobileInstall();
        BeanUtils.copyProperties(logInfo, install);
        install.setApp_package_id(application_id);
        install.setMobile_code(mobile.getString("mobile_id"));
        install.setLog_info_id(logInfo.getId());
        install.setId(Utils.generateUUID());
        AppPackage appPackage = appPackageMapper.selectByPrimaryKey(application_id);
        if (appPackage != null)
            install.setPackage_id(appPackage.getPackage_id());
        else
            install.setPackage_id(3L);
        JSONArray app = applications.getJSONArray("app");
        if (app_num != 0) {
            install.setTotal(app_num);
            install.setInstalled(success_num);
        } else {
            if ((app != null) && (app.size() > 0)) {
                install.setTotal(app.size());
            } else {
                install.setTotal(0);
            }
            install.setInstalled(0);
        }
        parseApp(install, app);
        return true;
    }

    @Override
    public boolean appActive(String box_id, String data, long user, String ip) throws InvalidOperation, TException {
        Box b = new Box();
        b.setBox_id(box_id);
        Box dbBox = boxMapper.selectOne(b);
        if (dbBox == null) return false;

        JSONObject jsonData = JSON.parseObject(data);
        JSONObject mobile = jsonData.getJSONObject("mobile_info");
        HashMap<String, Object> model = modelRefMapper.selectModelByName(
                mobile.get("brand"),
                mobile.get("model"),
                mobile.get("android_version"),
                mobile.get("baseband_version"));

        AppActiveData appActiveData = new AppActiveData();
        appActiveData.setId(Utils.generateUUID());
        appActiveData.setBox_id(dbBox.getId());
        appActiveData.setMobile_code(mobile.getString("mobile_id"));
        appActiveData.setImei(mobile.getString("imei"));
        appActiveData.setBrand_id((Long) model.get("brand_id"));
        appActiveData.setModel_id((Long) model.get("model_id"));
        appActiveData.setVersion_id((Long) model.get("version_id"));
        appActiveData.setBase_version_id((Long) model.get("base_version_id"));
        appActiveData.setIp(ip);
        appActiveData.setUser_id(user);
        appActiveData.setApp_package_id(jsonData.getLong("application_id"));
        appActiveData.setApp_id(jsonData.getLong("app_id"));
        appActiveData.setActive_time(parseDate(jsonData.getString("activit_time")));
        appActiveData.setCreate_time(new Date());

        appActiveDataMapper.insertSelective(appActiveData);
        return true;
    }

    @Override
    public boolean mobileActive(String box_id, String data, long user, String ip) throws InvalidOperation, TException {
        Box b = new Box();
        b.setBox_id(box_id);
        Box dbBox = boxMapper.selectOne(b);
        if (dbBox == null) return false;

        JSONObject jsonData = JSON.parseObject(data);
        JSONObject mobile = jsonData.getJSONObject("mobile_info");
        HashMap<String, Object> model = modelRefMapper.selectModelByName(
                mobile.get("brand"),
                mobile.get("model"),
                mobile.get("android_version"),
                mobile.get("baseband_version"));

        MobileActiveData mobileActiveData = new MobileActiveData();
        mobileActiveData.setId(Utils.generateUUID());
        mobileActiveData.setBox_id(dbBox.getId());
        mobileActiveData.setMobile_code(mobile.getString("mobile_id"));
        mobileActiveData.setImei(mobile.getString("imei"));
        mobileActiveData.setBrand_id((Long) model.get("brand_id"));
        mobileActiveData.setModel_id((Long) model.get("model_id"));
        mobileActiveData.setVersion_id((Long) model.get("version_id"));
        mobileActiveData.setBase_version_id((Long) model.get("base_version_id"));
        mobileActiveData.setIp(ip);
        mobileActiveData.setUser_id(user);
        mobileActiveData.setApp_package_id(jsonData.getLong("application_id"));
        mobileActiveData.setActive_time(parseDate(jsonData.getString("activit_time")));
        mobileActiveData.setCreate_time(new Date());

        mobileActiveDataMapper.insertSelective(mobileActiveData);
        return true;
    }

    private void parseApp(MobileInstall mobileInstall, JSONArray app) {
        int installapps = 0;
        if (app != null) {
            for (int i = 0; i < app.size(); i++) {
                try {
                    AppInstall appInstall = new AppInstall();
                    BeanUtils.copyProperties(mobileInstall, appInstall);
                    appInstall.setId(Utils.generateUUID());
                    JSONObject a = app.getJSONObject(i);
                    Long app_id = a.getLong("app_id");
                    Integer install_type = a.getInteger("install_type");
                    Integer install_result = a.getInteger("install_result");
                    if (install_result == 0) {
                        installapps++;
                    }
                    appInstall.setApp_id(app_id);
                    appInstall.setFail_code(install_result);
                    appInstall.setInstall_type(install_type);

                    appInstallMapper.insertSelective(appInstall);
                } catch (Exception e) {
                    log.error("error app install", e);
                    throw e;
                }
            }
        }

        try {
            if (mobileInstall.getInstalled() == 0) {
                mobileInstall.setInstalled(installapps);
            }
            Double rate = 0.0D;
            if ((mobileInstall.getTotal() != 0) && mobileInstall.getInstalled() != null) {
                rate = (double) mobileInstall.getInstalled() / mobileInstall.getTotal();
            }
            mobileInstall.setSuccess_rate((int) (rate * 100));
            mobileInstallMapper.insertSelective(mobileInstall);
        } catch (Exception e) {
            log.error("mobile_install error", e);
            throw e;
        }
    }

    private Date parseDate(String string) {
        try {
            return FastDateFormat.getInstance("yyyyMMddHHmmss").parse(string);
        } catch (Exception ignored) {}
        return new Date();
    }

    private Resources parseLogFile(JSONObject log_file) {
        Resources logResources = null;
        try {
            Object file_id = log_file.get("id");
            if (file_id != null && StringUtils.isNumeric(file_id.toString())) {
                logResources = resourcesMapper.selectByPrimaryKey(Integer.valueOf(file_id.toString()));
            }
            if (logResources == null) {
                String md5 = log_file.getString("md5");
                if (StringUtils.isNotEmpty(md5)) {
                    logResources = new Resources();
                    logResources.setId(Utils.generateUUID());
                    logResources.setCreate_time(new Date());
                    logResources.setMd5(md5);
                    logResources.setSize(log_file.getInteger("size"));
                    resourcesMapper.insert(logResources);
                }
            }
        } catch (Exception e) {
            log.error("刷机上传文件异常", e);
        }
        return logResources;
    }

    private List<HashMap<String, Object>> getRootConfig(String url) {
        List<HashMap<String, Object>> rootList = rootConfigMapper.listAllAndResources();
        if (rootList != null) {
            filterMoreInfo(rootList, url);
        }
        return rootList;
    }

    private List<HashMap<String, Object>> getModel(long user, String url) {
        List<HashMap<String, Object>> modelList = modelRefMapper.selectAllModel(null);
        if (modelList != null) {
            for (HashMap<String, Object> map : modelList) {
                Long id = (Long) map.get("id");
                map.put("mobile_id", id);
                map.put("info", getModelInfo(map));
                Map<String, Object> stepMap = new HashMap<>();
                List<HashMap<String, Object>> appWhiteList = appWhiteMapper.allAndResourcesListByModel(user, id);
                filterMoreInfo(appWhiteList, url);
                stepMap.put("roster", appWhiteList);
                List<HashMap<String, Object>> rootList = rootConfigMapper.allAndResourcesListByModel(id);
                filterMoreInfo(rootList, url);
                stepMap.put("root", rootList);
                List<AppPackage> appPackageList = appPackageMapper.allListByModel(user, id);
                List<Map<String, Object>> appList = new ArrayList<>();
                if (appPackageList != null) {
                    parseApps(url, appList, appPackageList);
                }
                stepMap.put("application", appList);
                map.put("step", stepMap);
            }
        }
        return modelList;
    }

    private Map<String, Object> getModelInfo(Map<String, Object> map) {
        Map<String, Object> info = new HashMap<>();
        info.put("brand_id", map.get("brand_id"));
        info.put("model_id", map.get("model_id"));
        info.put("version_id", map.get("version_id"));
        info.put("android_version_id", map.get("base_version_id"));
        info.put("brand", map.get("brand_name"));
        info.put("model", map.get("model_name"));
        info.put("android_version", map.get("version_name"));
        info.put("baseband_version", map.get("base_version_name"));
        map.remove("brand_id");
        map.remove("model_id");
        map.remove("version_id");
        map.remove("base_version_id");
        map.remove("brand_name");
        map.remove("model_name");
        map.remove("version_name");
        map.remove("base_version_name");
        return info;
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

    private List<Map<String, Object>> getAppPackage(long user, String url) {
        List<Map<String, Object>> appList = new ArrayList<>();
        List<AppPackage> appPackageList = appPackageMapper.allList(user);
        if (appPackageList != null && appPackageList.size() > 0) {
            parseApps(url, appList, appPackageList);
        }
        return appList;
    }

    private void parseApps(String url, List<Map<String, Object>> appList, List<AppPackage> appPackageList) {
        for (AppPackage appPackage : appPackageList) {
            Map<String, Object> appMap = new HashMap<>();
            appMap.put("id", appPackage.getId());
            appMap.put("name", appPackage.getName());
            appMap.put("is_root", appPackage.getRoot());
            appList.add(appMap);

            List<HashMap<String, Object>> apps = appPackageMapper.appAndResourcesAllList(appPackage.getId(), null);
            if (apps != null) {
                filterMoreInfo(apps, url);
            }
            appMap.put("apps", apps);
        }
    }

    private List<Map<String, Object>> getRequirePackage(long user, String url) {
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
                    filterMoreInfo(apps, url);
                }
                requireMap.put("apps", apps);
            }
        }
        return requireList;
    }

    private void filterMoreInfo(List<HashMap<String, Object>> apps, String url) {
        for (Map<String, Object> app : apps) {
            app.remove("memo");
            app.remove("resources_id");
            app.remove("create_time");
            if (app.containsKey("md5")) {
                app.put("url", url + app.get("md5"));
            }
        }
    }
}
