package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.App;
import com.alone.common.entity.AppPackage;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午11:46
 */
public interface AppPackageMapper extends PageMapper<AppPackage> {
    List<HashMap<String, Object>> listAppByPage(@Param("page") Page page, @Param("id") Long id, @Param("type") Integer type,
                                            @Param("sortName") String sortName, @Param("sortDir") String sortDir);
    List<App> appAllList(@Param("id") Long id, @Param("type") Integer type);

    List<HashMap<String, Object>> appAndResourcesAllList(@Param("id") Long id, @Param("type") Integer type);

    List<AppPackage> allList(@Param("user") Long user);
}
