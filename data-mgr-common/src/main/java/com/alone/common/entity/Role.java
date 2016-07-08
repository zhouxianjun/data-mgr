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
 * @date 16-7-7 下午9:00
 */
@Data
@Table(name = "t_role")
public class Role implements Serializable {
    @Id
    private Long id;

    private Long pid;

    private String name;

    private Boolean status;

    private Date create_time;

    private Date update_time;
}
