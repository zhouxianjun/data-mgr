package com.alone.core.mapper;

import com.alone.common.entity.InstallActive;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface InstallActiveMapper extends PageMapper<InstallActive> {
    List<InstallActive> allList(@Param("user") Long user);
}
