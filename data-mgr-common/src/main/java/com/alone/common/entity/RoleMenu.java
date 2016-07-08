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
 * @date 16-7-7 下午9:09
 */
@Data
@Table(name = "t_role_menu")
public class RoleMenu implements Serializable {
    @Id
    private Long role_id;

    @Id
    private Long menu_id;

    private Date create_time;
}
