package com.alone.core.mapper;

import com.alone.common.entity.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface MenuMapper extends Mapper<Menu> {
    List<Menu> listByUser(@Param("user") Long user, @Param("enable") Boolean enable);

    List<Menu> listByRole(@Param("role") Long role);

    Integer updateChildStatus(@Param("pid") Long pid, @Param("status") Boolean status);

    Integer deleteMenu(@Param("id") Long id);

    Integer deleteMenuInterface(@Param("id") Long id);
}
