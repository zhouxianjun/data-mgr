package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 上午12:04
 */
@Data
@Table(name = "t_app_require")
public class AppRequire {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private Long resources_id;

    private Integer type;

    private String memo;

    private Date create_time;
}
