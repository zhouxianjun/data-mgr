package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午9:57
 */
@Data
@Table(name = "t_mobile_base_version")
public class MobileBaseVersion {
    @Id
    private Long id;

    private String name;

    private Long version_id;
}
