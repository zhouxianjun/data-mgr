package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.Interface;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface InterfaceMapper extends Mapper<Interface> {
    List<Interface> listByUser(@Param("user") Long user, @Param("enable") Boolean enable);

    List<Interface> listByMenu(@Param("menu") Long menu);

    List<Interface> listByPage(@Param("page") Page<Interface> page, @Param("sortName") String sortName, @Param("sortDir") String sortDir);

    Integer updateChildStatus(@Param("pid") Long pid, @Param("status") Boolean status);
}
