package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.App;
import com.alone.common.entity.AppPackage;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午11:46
 */
public interface AppPackageMapper extends PageMapper<AppPackage> {
    List<Map<String, Object>> listAppByPage(@Param("page") Page page, @Param("id") Long id, @Param("type") Integer type,
                                            @Param("sortName") String sortName, @Param("sortDir") String sortDir);
    List<App> appAllList(@Param("id") Long id, @Param("type") Integer type);
}
