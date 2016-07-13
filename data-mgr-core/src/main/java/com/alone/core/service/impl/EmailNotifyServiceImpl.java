package com.alone.core.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alone.common.dto.EmailDto;
import com.alone.common.service.EmailNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/13 14:42
 */
@Service
public class EmailNotifyServiceImpl implements EmailNotifyService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmailMessageOfSimpleText(EmailDto email, Date date) {
        SimpleMailMessage simpleTextMessage = new SimpleMailMessage();
        simpleTextMessage.setFrom(email.getSender());
        simpleTextMessage.setTo(email.getReceivers());
        if(email.getBcc().length > 0) {
            simpleTextMessage.setBcc(email.getBcc());
        }
        if(email.getCc().length > 0) {
            simpleTextMessage.setCc(email.getCc());
        }
        simpleTextMessage.setText(email.getEmailContent());

        if(null == date) {
            date = new Date();
        }
        simpleTextMessage.setSentDate(date);

        javaMailSender.send(simpleTextMessage);
    }

    @Override
    public void sendEmailMessageOfHtmlText(EmailDto email, Date date) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(email.getSender());
        helper.setValidateAddresses(true);
        if(!StringUtils.isEmpty(email.getEmailContent())) {
            helper.setText(email.getEmailContent(), true);
        }
        helper.setSubject(email.getSubject());
        helper.setCc(email.getCc());
        helper.setTo(email.getReceivers());
        helper.setBcc(email.getBcc());
        if(null == date) {
            date = new Date();
        }
        helper.setSentDate(date);

        javaMailSender.send(message);
    }

    @Override
    public void sendEmailMessageOfAttachedFileAndSimpleText(EmailDto email, Date date, boolean isHtmlText) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(email.getSender());
        //helper.setValidateAddresses(true);
        helper.setText(email.getEmailContent(), isHtmlText);
        helper.setSubject(email.getSubject());
        helper.setCc(email.getCc());
        helper.setTo(email.getReceivers());
        helper.setBcc(email.getBcc());
        if(null == date) {
            date = new Date();
        }
        helper.setSentDate(date);

        for(File file : email.getAttachFile()) {
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(file.getName(), fileSystemResource);
        }
        javaMailSender.send(message);
    }
}
