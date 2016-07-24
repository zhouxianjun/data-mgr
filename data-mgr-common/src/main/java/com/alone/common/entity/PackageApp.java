package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-22 下午10:55
 */
@Data
@Table(name = "t_package_app")
public class PackageApp {
    @Id
    private Long app_package_id;

    @Id
    private Long app_id;

    @Id
    private Integer type;
}
