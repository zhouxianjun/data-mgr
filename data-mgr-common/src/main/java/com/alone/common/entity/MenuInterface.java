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
 * @date 16-7-7 下午9:05
 */
@Data
@Table(name = "t_menu_interface")
public class MenuInterface implements Serializable {
    @Id
    private Long menu_id;

    @Id
    private Long interface_id;

    private Date create_time;
}
