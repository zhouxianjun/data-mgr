package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.MobileModel;
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
public interface MobileModelMapper extends PageMapper<MobileModel> {
    List<HashMap<String, Object>> listByPageByBrand(@Param("page") Page page, @Param("brand") Long brand, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
