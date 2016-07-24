package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午10:55
 */
@Data
@Table(name = "t_app_package")
public class AppPackage {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private Boolean common;

    private Boolean root;

    private Long brand_id;

    private Long model_id;

    private Long version_id;

    private Long base_version_id;

    private Long package_id;

    private Date create_time;
}
