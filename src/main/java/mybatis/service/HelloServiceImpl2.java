package mybatis.service;

import mybatis.annotations.Hello;
import org.springframework.stereotype.Component;

/**
 * Created by jiaranran on 2016/7/13.
 */
//@Service
@Component("hello2se")
public class HelloServiceImpl2 implements HelloService {
    @Override
    @Hello
    public String sayHello(String s) {
        return  "hello"+s;
    }
}
