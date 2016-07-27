package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.ModelRef;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午12:08
 */
public interface ModelRefMapper extends Mapper<ModelRef> {
    List<HashMap<String, Object>> listModelByPage(@Param("page") Page page, @Param("id") Long id, @Param("type") Integer type, @Param("sortName") String sortName, @Param("sortDir") String sortDir);

    List<HashMap<String, Object>> selectAllModel(@Param("type") Integer type);

    HashMap<String, Object> selectModelByName(@Param("brand") Object brand, @Param("model") Object model, @Param("version") Object version, @Param("base") Object base);
}
