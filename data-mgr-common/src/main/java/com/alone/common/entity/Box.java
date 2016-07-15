package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/15 16:31
 */
@Data
@Table(name = "t_box")
public class Box {
    @Id
    private Long id;

    private Long user_id;

    private String box_id;

    private String ip;

    private String version;

    private Long login_count;

    private Boolean status;

    private Integer province_id;

    private Integer city_id;

    private Date create_time;

    private Date update_time;
}
