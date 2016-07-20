package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.MobileModel;
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
public interface MobileVersionMapper extends PageMapper<MobileVersion> {
    List<Map<String, Object>> listByPageByModel(@Param("page") Page page, @Param("model") Long model, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
