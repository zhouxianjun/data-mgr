import com.alone.common.dto.EmailDto;
import com.alone.common.service.EmailNotifyService;
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
 * @date 2016/7/13 14:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-core-db.xml"})
public class EmailTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private EmailNotifyService emailNotifyService;

    @Test
    public void sendTextTest() {
        EmailDto emailVo = new EmailDto();
        emailVo.setReceivers(new String[]{"715213471@qq.com"});
        emailVo.setCc(new String[]{});
        emailVo.setBcc(new String[]{});
        emailVo.setSubject("测试");
        emailVo.setSender("alone@cn-face.com");
        emailVo.setEmailContent("<html><body><h1>中国人民</h1><h5>测试<font color=red>测试测试测试测试测试测</font>试测试测试测试测试测试测试测试测试测试</h5></body></html>");
        emailNotifyService.sendEmailMessageOfSimpleText(emailVo, null);
    }
}
