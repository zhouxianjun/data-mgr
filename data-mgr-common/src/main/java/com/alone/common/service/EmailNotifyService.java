package com.alone.common.service;

import com.alone.common.dto.EmailDto;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/13 14:36
 */
public interface EmailNotifyService {
    /**
     * 发送简单文本Email消息
     * @param email
     */
    void sendEmailMessageOfSimpleText(EmailDto email, Date date);

    /**
     * 发送HTML格式的消息
     * @param email
     * @param date
     */
    void sendEmailMessageOfHtmlText(EmailDto email , Date date) throws MessagingException;

    /**
     * 带附件并且html格式邮件发送,带附件并简单文本格式邮件发送
     * @param email
     */
    void sendEmailMessageOfAttachedFileAndSimpleText(EmailDto email, Date date, boolean isHtmlText) throws MessagingException;
}
