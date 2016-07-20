package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.MobileBaseVersion;
import com.alone.common.entity.MobileVersion;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午9:58
 */
public interface MobileBaseVersionMapper extends PageMapper<MobileBaseVersion> {
    List<Map<String, Object>> listByPageByVersion(@Param("page") Page page, @Param("version") Long version, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
