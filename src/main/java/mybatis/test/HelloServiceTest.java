package mybatis.test;

import mybatis.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class HelloServiceTest {
//    @Autowired
    @Resource(name = "hellose")
    private HelloService helloService;
    ClassPathXmlApplicationContext ac;
    @org.junit.Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-common.xml"});
    }
    @org.junit.Test
    public void testSayHello() throws Exception {
//        HelloService helloService= (HelloService)ac.getBean("helloService");
        String string = helloService.sayHello("world");
        System.out.println(string);
    }
}