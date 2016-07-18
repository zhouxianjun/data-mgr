package com.alone.core.jms;

import com.alibaba.fastjson.JSON;
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
    @Resource(name = "topic-demo")
    private Destination demoTopic;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Object obj) {
        try {
            jmsTemplate.send(demoTopic, new MessageCreator() {
                @Override
                public Message createMessage(Session session)
                        throws JMSException {

                    return session.createTextMessage(JSON.toJSONString(obj));
                }
            });
            log.info("消息已发送");
        } catch (JmsException e) {
            log.error("消息异常(JmsException)", e);
        }
    }
}