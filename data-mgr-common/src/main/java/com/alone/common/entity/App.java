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
@Table(name = "t_app")
public class App {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private String zh_name;

    private String cp_name;

    private BigDecimal price;

    private Integer network;

    private Long resources_id;

    private Boolean open_network;

    private String memo;

    @Column(name = "`require`")
    private Boolean require;

    private Boolean white;

    private Boolean black;

    private Integer active_open_count;

    private Integer active_flow;

    private Integer active_stay_days;

    private Integer active_show_time;

    private Boolean active_open_network;

    private Date create_time;
}
