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
 * @date 16-7-28 下午9:43
 */
@Data
@Table(name = "t_deduction")
public class Deduction {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private Integer percent;

    private Integer start;

    private Integer model;

    private Boolean status;

    private Date start_time;

    private Date end_time;

    private Date create_time;

    private Long user_id;
}
