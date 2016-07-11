package com.alone.core.mapper;

import com.alone.common.entity.Role;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface RoleMapper extends Mapper<Role> {
    Integer updateStatus(@Param("ids") Long[] ids, @Param("status") Boolean status);

    Integer updateChildStatus(@Param("pid") Long pid, @Param("status") Boolean status);

    List<Role> listByUser(@Param("user") Long user);
}
