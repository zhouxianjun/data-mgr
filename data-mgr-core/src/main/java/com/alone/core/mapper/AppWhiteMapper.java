package com.alone.core.mapper;

import com.alone.common.entity.AppWhite;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface AppWhiteMapper extends PageMapper<AppWhite> {
    List<AppWhite> allList(@Param("user") Long user);

    List<HashMap<String, Object>> allAndResourcesListByModel(@Param("user") Long user,
                                                 @Param("brand_id") Long brand_id,
                                                 @Param("model_id") Long model_id,
                                                 @Param("version_id") Long version_id,
                                                 @Param("base_version_id") Long base_version_id);
}
