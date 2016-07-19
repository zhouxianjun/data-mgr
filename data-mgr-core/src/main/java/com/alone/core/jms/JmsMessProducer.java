package com.alone.core.jms;

import com.alibaba.fastjson.JSON;
import com.alone.common.dto.BasicEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/18 11:05
 */
@Component
@Slf4j
public class JmsMessProducer {
    @Resource(name = "topic-box")
    private Destination boxTopic;
    @Resource(name = "topic-sdk")
    private Destination sdkTopic;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Object obj, String type) {
        if (type == null) {
            send(obj, "box");
            send(obj, "sdk");
        } else {
            if (!type.equals("box") && !type.equals("sdk")) {
                log.warn("消息类型错误,发送失败");
                return;
            }
            send(obj, type);
        }
    }

    private void send(final Object obj, String type){
        try {
            final String jsonString = JSON.toJSONString(obj);
            jmsTemplate.send(type.equals("box") ? boxTopic : sdkTopic, new MessageCreator() {
                @Override
                public Message createMessage(Session session)
                        throws JMSException {
                    return session.createTextMessage(jsonString);
                }
            });
            log.info("消息已发送 type: {}, content: {}", type, jsonString);
        } catch (JmsException e) {
            log.error("消息异常(JmsException)", e);
        }
    }
}