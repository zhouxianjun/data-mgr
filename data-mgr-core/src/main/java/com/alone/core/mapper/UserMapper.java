package com.alone.core.mapper;

import com.alone.common.entity.User;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
