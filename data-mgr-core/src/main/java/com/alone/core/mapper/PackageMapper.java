package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.Package;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午11:46
 */
public interface PackageMapper extends PageMapper<Package> {
    List<HashMap<String, Object>> listPackageByPage(@Param("page") Page page, @Param("id") Long id, @Param("sortName") String sortName, @Param("sortDir") String sortDir);
}
