package com.alone.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alone.common.dto.Page;
import com.alone.common.entity.AppImg;
import com.alone.common.entity.AppRequire;
import com.alone.common.entity.PackageApp;
import com.alone.common.entity.Resources;
import com.alone.common.util.Utils;
import com.alone.thrift.struct.InvalidOperation;
import com.alone.thrift.struct.PageParamStruct;
import com.alone.thrift.struct.PageStruct;
import com.alone.thrift.struct.ResourcesStruct;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-19 下午7:52
 */
public class Util {
    public static <T> PageStruct buildListPage(PageParamStruct page, PageMapper<T> pageMapper) {
        Page<T> p = new Page<>();
        p.setPageNum(page.getPage());
        p.setPageSize(page.getPageSize());
        List list = pageMapper.listByPage(p, page.getSortName(), page.getSortDir());
        return new PageStruct(p.getPageNum(), p.getPageSize(),
                p.getCount(), page.getPage(), JSONArray.toJSONString(list, SerializerFeature.WriteMapNullValue));
    }

    public static boolean changeAppImg(long id, List<ResourcesStruct> resources, Mapper appMapper, Mapper<AppImg> appImgMapper, Mapper<Resources> resourcesMapper) throws InvalidOperation {
        if (resources == null || resources.size() <= 0)
            return false;
        if (appMapper.selectByPrimaryKey(id) == null)
            throw new InvalidOperation(500, "应用不存在");
        Example example = new Example(AppImg.class);
        example.createCriteria().andEqualTo("app_id", id);
        appImgMapper.deleteByExample(example);
        for (ResourcesStruct resource : resources) {
            Long rid = null;
            if (resource.getId() > 0) {
                Resources db = resourcesMapper.selectByPrimaryKey(resource.getId());
                if (db != null) {
                    rid = db.getId();
                }
            } else {
                if (StringUtils.isEmpty(resource.getMd5()))
                    continue;
                Resources r = new Resources();
                Utils.java2Thrift(r, resource);
                r.setId(Utils.generateUUID());
                r.setCreate_time(new Date());
                resourcesMapper.insertSelective(r);
                rid = r.getId();
            }
            AppImg img = new AppImg();
            img.setResources_id(rid);
            img.setApp_id(id);
            appImgMapper.insert(img);
        }
        return true;
    }

    public static long changeAppFile(long id, ResourcesStruct resources, Mapper<Resources> resourcesMapper) {
        if (resources.getId() > 0) {
            Resources db = resourcesMapper.selectByPrimaryKey(resources.getId());
            if (db != null) {
                return resources.getId();
            }
        }
        Resources r = new Resources();
        Utils.java2Thrift(r, resources);
        r.setId(Utils.generateUUID());
        r.setCreate_time(new Date());
        resourcesMapper.insertSelective(r);
        return r.getId();
    }

    public static boolean removeApp(long id, Mapper<AppImg> appImgMapper, Mapper mapper) throws InvalidOperation {
        Example example = new Example(AppImg.class);
        example.createCriteria().andEqualTo("app_id", id);
        appImgMapper.deleteByExample(example);

        boolean isDel = mapper.deleteByPrimaryKey(id) > 0;
        if (!isDel) {
            throw new InvalidOperation(500, "操作失败");
        }
        return true;
    }

    public static void checkApps(List<Long> pre, List<Long> install, Long id, Mapper<PackageApp> packageAppMapper) {
        Example del = new Example(PackageApp.class);
        del.createCriteria().andEqualTo("app_package_id", id);
        packageAppMapper.deleteByExample(del);
        if (pre != null && pre.size() > 0) {
            for (Long aLong : pre) {
                if (aLong != null && aLong > 0) {
                    PackageApp packageApp = new PackageApp();
                    packageApp.setApp_id(aLong);
                    packageApp.setApp_package_id(id);
                    packageApp.setType(1);
                    packageAppMapper.insert(packageApp);
                }
            }
        }

        if (install != null && install.size() > 0) {
            for (Long aLong : install) {
                if (aLong != null && aLong > 0) {
                    PackageApp packageApp = new PackageApp();
                    packageApp.setApp_id(aLong);
                    packageApp.setApp_package_id(id);
                    packageApp.setType(2);
                    packageAppMapper.insert(packageApp);
                }
            }
        }
    }
}
