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
 * @date 16-7-24 上午11:25
 */
@Data
@Table(name = "t_root_config")
public class RootConfig {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private String version;

    private String memo;

    private Long resources_id;

    private Date create_time;
}
