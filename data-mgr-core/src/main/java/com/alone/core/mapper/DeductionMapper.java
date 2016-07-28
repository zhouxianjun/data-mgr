package com.alone.core.mapper;

import com.alone.common.entity.App;
import com.alone.common.entity.Deduction;
import com.alone.common.entity.User;
import com.alone.core.PageMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-28 下午9:49
 */
public interface DeductionMapper extends PageMapper<Deduction> {
    List<User> getUsers(@Param("id") Long id);

    List<App> getApps(@Param("id") Long id);
}
