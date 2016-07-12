import com.alone.thrift.service.RoleService;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxianjun(Alone)
 * @ClassName:
 * @Description:
 * @date 2016/7/12 11:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-core-db.xml"})
public class RoleServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private RoleService.Iface roleService;

    @Test
    public void setMenusTest() throws TException {
        List<Long> menus = new ArrayList<>();
        menus.add(1L);
        boolean res = roleService.setMenus(2L, 1L, menus);
        System.out.println(res);
    }

    @Test
    public void rolesBySetUserTest() throws TException {
        List res = roleService.rolesBySetUser(2L, 1L);
        System.out.println(res);
    }

    @Override
    @Resource(name = "coreWriteDataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
