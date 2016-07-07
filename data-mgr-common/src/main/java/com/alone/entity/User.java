package com.alone.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-7 下午9:03
 */
@Data
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    private Long id;

    private String username;

    private String password;

    private String name;

    private Date create_time;

    private Boolean status;
}
