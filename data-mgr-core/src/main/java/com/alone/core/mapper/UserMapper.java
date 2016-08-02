package com.alone.core.mapper;

import com.alone.common.entity.Role;
import com.alone.common.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface UserMapper extends Mapper<User> {
    List<User> listByUser(@Param("user") Long ids);

    Integer updateChildStatus(@Param("pid") Long pid, @Param("status") Boolean status);

    Integer deleteUserChildrenRoles(@Param("user") Long user, @Param("roles") String roles);

    HashMap<String, Object> info(@Param("id") Long id);

    List<Role> getRoles(@Param("user") Long user);
}
