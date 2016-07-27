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
public class MobileInstall {
    @Id
    private Long id;

    private Long box_id;

    private Long user_id;

    private String mobile_code;

    private String imei;

    private Long brand_id;

    private Long model_id;

    private Long version_id;

    private Long base_version_id;

    private Long app_package_id;

    private Integer fail_code;

    private Integer installed;

    private Integer total;

    private String memo;

    private Integer success_rate;

    private Long log_info_id;

    private Long package_id;

    private Date start_time;

    private Date end_time;

    private Date create_time;
}
