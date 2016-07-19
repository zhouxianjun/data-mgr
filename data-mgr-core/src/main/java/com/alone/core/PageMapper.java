package com.alone.core;

import com.alone.common.dto.Page;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-19 下午7:49
 */
public interface PageMapper<T> extends Mapper<T> {
    List<Map<String, Object>> listByPage(@Param("page") Page page, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
