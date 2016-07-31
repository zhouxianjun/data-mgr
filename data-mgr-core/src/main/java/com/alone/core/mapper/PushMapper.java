package com.alone.core.mapper;

import com.alone.common.entity.Push;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午5:21
 */
public interface PushMapper extends PageMapper<Push> {
    List<HashMap<String, Object>> getUnRead(@Param("user") Long user, @Param("client") String client, @Param("type") Integer type);

    int readPush(@Param("user") Long user, @Param("client") String client, @Param("type") Integer type, @Param("push") Long push);
}
