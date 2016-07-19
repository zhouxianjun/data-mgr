package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/15 16:31
 */
@Data
@Table(name = "t_app_active")
public class AppActive {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private Integer open_count;

    private Integer flow;

    private Integer stay_days;

    private Integer show_time;

    private Boolean open_network;

    private Date create_time;
}
