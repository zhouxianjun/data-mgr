package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-20 下午9:55
 */
@Data
@Table(name = "t_mobile_model")
public class MobileModel {
    @Id
    private Long id;
    private String name;
    private Long brand_id;
}
