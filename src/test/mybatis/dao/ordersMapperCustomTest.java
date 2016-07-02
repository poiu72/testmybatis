package mybatis.dao;

import junit.framework.TestCase;
import mybatis.model.Orders;
import mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ordersMapperCustomTest extends TestCase {
    private SqlSessionFactory sqlSessionFactory;
    public void setUp() throws Exception {
        super.setUp();
        String resource="SqlMapConfig.xml";
        InputStream InputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);

    }

    public void tearDown() throws Exception {

    }
    @Test
    public void testFindOrderUser() throws Exception {
        SqlSession sqlSession= sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectByPrimaryKey(1);
        user.setUsername("lisi");
        userMapper.updateByPrimaryKeySelective(user);
//        sqlSession.commit();
        User user1=userMapper.selectByPrimaryKey(1);
        System.out.println(user1);
        OrdersMapperCustom ordersMapperCustom =sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list1=ordersMapperCustom.findUserOrderLazy();
        for (Orders orders:list1) {
            User user2= orders.getUser();
            System.out.println(user2);
        }
        sqlSession.close();
    }
}