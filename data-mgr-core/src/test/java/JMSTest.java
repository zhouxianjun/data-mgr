import com.alone.core.jms.JmsMessProducer;
import com.alone.thrift.struct.VersionStruct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/18 11:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-core-db.xml", "classpath:spring-mq.xml"})
public class JMSTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private JmsMessProducer jmsMessProducer;

    @Test
    public void sendTest() {
        jmsMessProducer.sendMessage(new VersionStruct().setVersion("test"), "box");
    }
}
