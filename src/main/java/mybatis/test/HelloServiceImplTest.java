package mybatis.test;

import mybatis.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
/**
 * Created by jiaranran on 2016/7/13.
 */
@ContextConfiguration(locations = "classpath:spring-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloServiceImplTest {
    @Resource(name="hellose")
    private HelloService helloService;
    /*@Resource
    private HelloAapect helloAapect;*/
    @Test
    public void testSayHello() throws Exception {
//        helloAapect.cutSayHello();
        String string = helloService.sayHello("world");
        System.out.println(string+"------------------------");
    }
}
