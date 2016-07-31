package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 下午4:59
 */
@Data
@Table(name = "t_push")
public class Push {
    @Id
    private Long id;

    private Long user_id;

    @Column(name = "`name`")
    private String name;

    private Integer type;

    private Long img_resources_id;

    @Transient
    private String img_url;

    private String text;

    private Integer client_type;

    private Long app_resources_id;

    @Transient
    private String app_url;

    private BigDecimal deduct;

    private String url;

    private Integer status;

    private Date create_time;

    private Date start_time;

    private Date end_time;
}
