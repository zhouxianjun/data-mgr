package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.RootConfig;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午12:04
 */
public interface RootConfigMapper extends PageMapper<RootConfig> {
    List<Map<String, Object>> listModelByPage(@Param("page") Page page, @Param("id") Long id, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
