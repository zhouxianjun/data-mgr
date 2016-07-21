package com.alone.core.mapper;

import com.alone.common.entity.App;
import com.alone.common.entity.Resources;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface AppMapper extends PageMapper<App> {
    List<Resources> getImgs(@Param("id") Long id);
}
