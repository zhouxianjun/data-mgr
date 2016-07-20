package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午9:54
 */
@Data
@Table(name = "t_mobile_brand")
public class MobileBrand {
    @Id
    private Long id;
    private String name;
}
