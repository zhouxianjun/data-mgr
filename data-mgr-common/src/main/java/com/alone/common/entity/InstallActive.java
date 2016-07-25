package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-25 下午10:42
 */
@Data
@Table(name = "t_install_active")
public class InstallActive {
    @Id
    private Long id;

    private String name;

    private String memo;

    private Integer hours;

    private Date create_time;
}
