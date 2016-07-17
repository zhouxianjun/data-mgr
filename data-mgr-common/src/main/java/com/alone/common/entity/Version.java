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
 * @date 2016/7/15 16:31
 */
@Data
@Table(name = "t_version")
public class Version {
    @Id
    private Long id;

    private Long resource;

    private String version;

    private Integer version_code;

    @Column(name = "`desc`")
    private String desc;

    private Date create_time;
}
