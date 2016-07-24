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
 * @date 16-7-22 下午10:55
 */
@Data
@Table(name = "t_require_package")
public class RequirePackage {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private String android_version;

    private Boolean root;

    private Date create_time;
}
