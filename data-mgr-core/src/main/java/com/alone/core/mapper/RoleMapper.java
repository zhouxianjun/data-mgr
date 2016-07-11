package com.alone.core.mapper;

import com.alone.common.entity.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

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

    Set<Long> getSameIncludeMenuOfExcludeSelf(@Param("user") Long user, @Param("role") Long role, @Param("include") String include);

    Integer deleteRoleChildrenMenus(@Param("user") Long user, @Param("role") Long role, @Param("menus") String menus);
}
