package com.alone.core.mapper;

import com.alone.common.entity.Box;
import com.alone.common.entity.Version;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface BoxMapper extends PageMapper<Box> {
    List<Box> allList(@Param("user") Long user);

    Version getNewVersion(@Param("box") String box);
}
