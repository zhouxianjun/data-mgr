package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-24 上午11:27
 */
@Data
@Table(name = "t_model_ref")
public class ModelRef {
    @Id
    private Long id;

    private Long brand_id;

    private Long model_id;

    private Long version_id;

    private Long base_version_id;

    private Long ref_id;

    private Integer type;
}
