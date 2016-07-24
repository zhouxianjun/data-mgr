package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.Package;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午11:46
 */
public interface PackageMapper extends PageMapper<Package> {
    List<Map<String, Object>> listPackageByPage(@Param("page") Page page, @Param("id") Long id, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
