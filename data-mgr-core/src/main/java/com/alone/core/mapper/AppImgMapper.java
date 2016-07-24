package com.alone.core.mapper;

import com.alone.common.entity.AppImg;
import com.alone.common.entity.Resources;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:55
 */
public interface AppImgMapper extends Mapper<AppImg> {
    List<Resources> getImgs(@Param("id") Long id);
}
