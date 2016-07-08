package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午8:56
 */
@Data
@Table(name = "t_interface")
public class Interface implements Serializable {
    @Id
    private Long id;

    private String name;

    private String auth;

    private String description;

    private Integer seq;

    private Boolean status;

    private Date create_time;
}
