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

    List<HashMap<String, Object>> allAndResourcesListByModel(@Param("user") Long user, @Param("model") Long model);
}
