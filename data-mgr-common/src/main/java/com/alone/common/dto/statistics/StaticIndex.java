package com.alone.common.dto.statistics;

import lombok.Data;

import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-8-4 下午8:26
 */
@Data
public class StaticIndex {
    private Date date;

    private Long installed;

    private Long app_active;

    private Long mobile_active;

    private Long deduction_app_active;

    private Long deduction_mobile_active;
}
