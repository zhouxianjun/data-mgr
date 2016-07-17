package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.App;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface AppMapper extends Mapper<App> {
    List<Map<String, Object>> listByPage(@Param("page") Page page, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
