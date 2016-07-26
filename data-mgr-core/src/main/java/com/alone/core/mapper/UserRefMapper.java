package com.alone.core.mapper;

import com.alone.common.entity.Box;
import com.alone.common.entity.UserRef;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface UserRefMapper extends Mapper<UserRef> {
    Box getBox(@Param("user") Long user, @Param("box") String box);
}
