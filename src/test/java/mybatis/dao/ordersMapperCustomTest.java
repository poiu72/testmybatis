package mybatis.dao;

import junit.framework.TestCase;
import mybatis.model.OrdersCustom;
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
        OrdersMapperCustom ordersMapperCustom =sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersCustom> list=ordersMapperCustom.findOrderUser();
        System.out.println(list);
        sqlSession.close();
    }
}