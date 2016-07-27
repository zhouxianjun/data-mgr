package com.alone.common.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 16-7-27 下午10:02
 */
@Data
@Table(name = "t_log_info")
public class LogInfo {
    @Id
    private Long id;

    private Long box_id;

    private Long brand_id;

    private Long model_id;

    private Long version_id;

    private Long base_version_id;

    private String imei;

    private String result;

    private Integer fail_code;

    private Long log_resources_id;

    private String memo;

    private Integer success_rate;

    private Long user_id;

    private String ip;

    private String local_ip;

    private Date start_time;

    private Date end_time;

    private Date create_time;
}
