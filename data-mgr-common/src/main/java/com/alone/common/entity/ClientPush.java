package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-30 上午10:12
 */
@Data
@Table(name = "t_client_push")
public class ClientPush {
    @Id
    private Long user_id;
    @Id
    private String client_code;
    @Id
    private Integer client_type;

    private Long push_id;
}
