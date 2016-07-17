package mybatis.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiaranran on 2016/7/14.
 */
@ContextConfiguration(locations ={ "classpath*:/spring-common.xml", "classpath*:/spring-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSupport {
}
