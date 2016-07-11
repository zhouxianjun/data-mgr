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
 * @date 16-7-7 下午8:50
 */
@Data
@Table(name = "t_menu")
public class Menu implements Serializable {
    @Id
    private Long id;

    private Long pid;

    private String name;

    private String description;

    private Integer seq;

    private Boolean status;

    private Date create_time;

    private String path;

    private String target;

    private String icon;

    private String pids;
}
