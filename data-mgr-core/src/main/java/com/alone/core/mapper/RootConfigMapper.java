package com.alone.core.mapper;

import com.alone.common.entity.RootConfig;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午12:04
 */
public interface RootConfigMapper extends PageMapper<RootConfig> {
    List<HashMap<String, Object>> listAllAndResources();

    List<HashMap<String, Object>> allAndResourcesListByModel(@Param("model") Long model);
}
