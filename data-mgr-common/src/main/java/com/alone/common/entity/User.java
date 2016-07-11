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
 * @date 16-7-7 下午9:03
 */
@Data
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    private Long id;

    private Long pid;

    private String username;

    private String password;

    private String name;

    private String real_name;

    private String company;

    private Integer city_id;

    private Integer province_id;

    private String email;

    private String phone;

    private Date create_time;

    private Boolean status;

    private String pids;
}
