package sy.test;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sy.dao.UserMapper;
import sy.model.User;
import sy.model.UserCustom;
import sy.model.UserQueryVo;
import sy.service.UserServiceI;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-common.xml","classpath:spring-mybatis.xml"})
public class TestMybatis{
	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
//	private ApplicationContext ac;
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
//	@Before
//	public void before(){
//		ac = new ClassPathXmlApplicationContext(new String[]{"spring-common.xml","spring-mybatis.xml"});
//		userService = (UserServiceI)ac.getBean("userService");
//	}
	@Test
	public void test1(){
		User u = userService.getUserById("2");
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test2(){
		List<User> u = userService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test3() {
		List<User> l = userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test4() {
		List<User> l = userService.getAll3();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test5() {
		List<User> l = userService.getAll4();
		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void selectByPrimaryKey() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		User user = SqlSession.selectOne("sy.dao.UserMapper.selectByPrimaryKey", "1");
		System.out.println(user.getUsername());
		SqlSession.close();
	}
	@Test
	public void findUserByNameTest() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		List<User> list = SqlSession.selectList("sy.dao.UserMapper.findUserByName", "dao");
		System.out.println(list.get(0).toString()+"------------------"+list.size());
		SqlSession.close();
	}
	@Test
	public void findUserList() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		UserCustom userCustom=new UserCustom();
		UserQueryVo userQueryVo=new UserQueryVo();
		List<Integer> list=new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(7);
//		userCustom.setUsername("dao");
//		userCustom.setPassword("123");
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.setIdlist(list);
		UserMapper userMapper=SqlSession.getMapper(UserMapper.class);
		List<UserCustom> list1 =userMapper.findUserList(userQueryVo);
//		List<UserCustom> list = SqlSession.selectList("sy.dao.UserMapper.findUserList", userQueryVo);
		System.out.println(list1.get(0).getUsername()+"------------------"+list.size());
		SqlSession.close();
	}
	@Test
	public void selectCount() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		UserCustom userCustom=new UserCustom();
		UserQueryVo userQueryVo=new UserQueryVo();
		userCustom.setUsername("dao");
		userCustom.setPassword("123");
		userQueryVo.setUserCustom(userCustom);
		UserMapper userMapper=SqlSession.getMapper(UserMapper.class);
		int count= userMapper.selectCount(userQueryVo);
		System.out.println(count);
		SqlSession.close();
	}
	@Test
	public void insertSelectiveTest() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		Date date1=new Date();
		Date date2=new Date();
		User user=new User();
		user.setUsername("笨蛋");
		user.setPassword("123");
		user.setCreatetime(date1);
		user.setLastupdate(date2);
		user.setStatus(1);
		System.out.println(SqlSession.insert("sy.dao.UserMapper.insertSelective", user));
		SqlSession.commit();
		SqlSession.close();
	}
	@Test
	public void deleteByPrimaryKey() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		SqlSession.delete("sy.dao.UserMapper.deleteByPrimaryKey", "19");
		SqlSession.commit();
		SqlSession.close();
	}
	@Test
	public void updateByPrimaryKeySelective() throws IOException {
		String resource="SqlMapConfig.xml";
		InputStream InputStream= Resources.getResourceAsStream(resource);
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(InputStream);
		SqlSession SqlSession= SqlSessionFactory.openSession();
		User user = SqlSession.selectOne("sy.dao.UserMapper.selectByPrimaryKey", "2");
		user.setUsername("dada");
		SqlSession.selectOne("sy.dao.UserMapper.updateByPrimaryKeySelective", user);
		SqlSession.commit();
		SqlSession.close();
	}
}
