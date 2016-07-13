package com.alone.common.dto;

import lombok.Data;

import java.io.File;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/13 14:34
 */
@Data
public class EmailDto {
    /**
     * 邮件发送者
     */
    private String sender;

    /**
     * 邮件接收者
     */
    private String [] receivers;

    /**
     * 邮件抄送人
     */
    private String [] cc;

    /**
     * 邮件抄送人
     */
    private String [] bcc;

    /**
     * Email发送的内容
     */
    private String emailContent;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件附件
     */
    private File[] attachFile;
}
