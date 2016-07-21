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
 * @date 16-7-22 上午12:04
 */
@Data
@Table(name = "t_app_white")
public class AppWhite {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private String version;

    private Long resources_id;

    private String memo;

    private Long brand_id;

    private Long model_id;

    private Long version_id;

    private Long base_version_id;

    private Date create_time;
}
