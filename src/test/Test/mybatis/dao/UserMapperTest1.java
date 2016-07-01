package mybatis.dao;

import junit.framework.TestCase;
import mybatis.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest1 extends TestCase {
    private ApplicationContext ac;
    public void setUp() throws Exception {
        super.setUp();
        ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-mybatis.xml"});

    }

    public void testSelectByPrimaryKey() throws Exception {
        UserMapper userMapper= (UserMapper)ac.getBean("userMapper");
        User user= userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}