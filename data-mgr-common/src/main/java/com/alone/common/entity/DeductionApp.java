package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-28 下午9:43
 */
@Data
@Table(name = "t_deduction_app")
public class DeductionApp {
    @Id
    private Long deduction_id;

    @Id
    private Long app_id;
}
