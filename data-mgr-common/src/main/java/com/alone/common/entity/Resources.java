package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/15 15:49
 */
@Data
@Table(name = "t_resources")
public class Resources {
    @Id
    private Long id;

    private String path;

    private String md5;

    private Integer size;

    private String name;

    private Date create_time;
}
