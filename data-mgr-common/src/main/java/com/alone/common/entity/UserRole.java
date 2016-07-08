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
 * @date 16-7-7 下午9:07
 */
@Data
@Table(name = "t_user_role")
public class UserRole implements Serializable {
    @Id
    private Long user_id;

    @Id
    private Long role_id;

    private Date create_time;

    private Long oper_id;
}
