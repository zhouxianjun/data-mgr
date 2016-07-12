import com.alone.thrift.service.MenuService;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/12 11:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-core-db.xml"})
public class MenuServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private MenuService.Iface menuService;

    @Test
    public void menusBySetRoleTest() throws TException {
        List res = menuService.menusBySetRole(1, 2);
        System.out.println(res);
    }

    @Test
    public void menusByUserTest() throws TException {
        List res = menuService.menusByUser(2);
        System.out.println(res);
    }

    @Override
    @Resource(name = "coreWriteDataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
