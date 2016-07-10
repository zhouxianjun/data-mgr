package com.alone.core.mapper;

import com.alone.common.entity.Menu;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface MenuMapper extends Mapper<Menu> {
    List<Menu> listByUser(@Param("user") Long user);
}
