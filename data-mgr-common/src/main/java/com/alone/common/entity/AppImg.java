package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-17 下午8:27
 */
@Data
@Table(name = "t_app_img")
public class AppImg {
    private Long app_id;

    private Long resources_id;
}
