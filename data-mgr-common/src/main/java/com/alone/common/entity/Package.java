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
@Table(name = "t_package")
public class Package {
    @Id
    private Long id;

    @Column(name = "`name`")
    private String name;

    private BigDecimal price;

    private Date create_time;
}
