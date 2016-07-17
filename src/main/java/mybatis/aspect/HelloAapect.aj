package mybatis.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by jiaranran on 2016/7/13.
 */
@Aspect
@Component
public class HelloAapect {
//    @Before("execution(* mybatis.service.HelloServiceImpl.sayHello(..)")
    @Before("@annotation(mybatis.annotations.Hello)")
    public void cutSayHello(){
        System.out.println("cut say hello----------------");
    }

}
