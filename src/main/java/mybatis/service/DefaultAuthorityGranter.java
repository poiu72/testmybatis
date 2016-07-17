package mybatis.service;

import mybatis.model.UserEntity;
import mybatis.repository.DemoRepository;
import org.springframework.security.authentication.jaas.AuthorityGranter;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by jiaranran on 2016/7/15.
 */
public class DefaultAuthorityGranter implements AuthorityGranter {
    @Resource
    private DemoRepository demoRepository;
    @Override
    public Set<String> grant(Principal principal) {
        String name = principal.getName();
      List <UserEntity> list= demoRepository.findByUsername(name);
        System.out.println("grant"+name);
        return Collections.singleton(list.get(0).getRole());
    }
}
