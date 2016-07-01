package mybatis.dao;

import junit.framework.TestCase;
import mybatis.model.User;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class UserDaoImpTest extends TestCase {
    private ApplicationContext ac;
    protected void setUp() throws Exception {
        super.setUp();
        ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-mybatis.xml"});

    }

    public void testSelectByPrimaryKey() throws Exception {
        UserDao userDao= (UserDao)ac.getBean("userDao");
        User user= userDao.selectByPrimaryKey(1);
        System.out.println(user);
    }
}