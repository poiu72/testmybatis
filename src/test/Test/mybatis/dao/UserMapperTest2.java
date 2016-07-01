package mybatis.dao;

import junit.framework.TestCase;
import mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserMapperTest2 extends TestCase {
    private SqlSessionFactory sqlSessionFactory;
    public void setUp() throws Exception {
        super.setUp();
        String resource="SqlMapConfig.xml";
        InputStream InputStream= Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
    }

    public void testSelectByPrimaryKey() throws Exception {
        SqlSession sqlSession1= sqlSessionFactory.openSession();
        SqlSession sqlSession2= sqlSessionFactory.openSession();
        SqlSession sqlSession3= sqlSessionFactory.openSession();
        UserMapper userMapper1=sqlSession1.getMapper(UserMapper.class);
        User user1=userMapper1.selectByPrimaryKey(2);
        /*将sqlsession中的数据提交到二级缓存*/
        sqlSession1.close();
        System.out.println(user1);


        UserMapper userMapper3= sqlSession3.getMapper(UserMapper.class);
        User user=userMapper3.selectByPrimaryKey(1);
        user.setUsername("zhaoliu");
        userMapper3.updateByPrimaryKeySelective(user);
        /*清空二级缓存中的数据*/
        sqlSession3.commit();
        sqlSession3.close();

        UserMapper userMapper2= sqlSession2.getMapper(UserMapper.class);
        User user3=userMapper2.selectByPrimaryKey(1);
        System.out.println(user3);
        sqlSession2.close();
    }
}