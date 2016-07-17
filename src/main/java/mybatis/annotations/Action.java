package mybatis.annotations;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

/**
 * Created by jiaranran on 2016/7/13.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Scope("prototype")
public @interface Action {
}
