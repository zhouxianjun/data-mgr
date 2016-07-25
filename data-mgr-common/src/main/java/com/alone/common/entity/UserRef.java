package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-25 下午9:09
 */
@Data
@Table(name = "t_user_ref")
public class UserRef {
    @Id
    private Long user_id;

    @Id
    private Long ref_id;

    @Id
    private Integer type;
}
