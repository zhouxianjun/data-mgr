package com.alone.core.mapper;

import com.alone.common.dto.statistics.StaticIndex;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-8-4 下午8:25
 */
public interface StatisticsMapper {
    List<StaticIndex> getStaticIndexByDate(
            @Param("user") Long user,
            @Param("start") Date start,
            @Param("end") Date end,
            @Param("province") Long province,
            @Param("city") Long city,
            @Param("sortName") String sortName,
            @Param("sortDir") String sortDir
    );
}
