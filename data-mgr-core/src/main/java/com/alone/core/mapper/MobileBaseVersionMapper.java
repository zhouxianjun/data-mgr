package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.MobileBaseVersion;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午9:58
 */
public interface MobileBaseVersionMapper extends PageMapper<MobileBaseVersion> {
    List<HashMap<String, Object>> listByPageByVersion(@Param("page") Page page, @Param("version") Long version, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
