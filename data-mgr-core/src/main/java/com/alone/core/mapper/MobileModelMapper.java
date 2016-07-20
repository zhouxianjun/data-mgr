package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.MobileBrand;
import com.alone.common.entity.MobileModel;
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
public interface MobileModelMapper extends PageMapper<MobileModel> {
    List<Map<String, Object>> listByPageByBrand(@Param("page") Page page, @Param("brand") Long brand, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
