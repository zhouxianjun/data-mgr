package com.alone.core.mapper;

import com.alone.common.dto.Page;
import com.alone.common.entity.Interface;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface InterfaceMapper extends PageMapper<Interface> {
    List<Interface> listByUser(@Param("user") Long user, @Param("enable") Boolean enable);

    List<Interface> listByMenu(@Param("menu") Long menu);

    Integer updateChildStatus(@Param("pid") Long pid, @Param("status") Boolean status);
}
