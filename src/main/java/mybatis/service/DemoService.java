package mybatis.service;

import mybatis.model.UserEntity;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by jiaranran on 2016/7/14.
 */
public interface DemoService {
    @RolesAllowed("ROLE_ADMIN")
    List<UserEntity> findByUsername(String name);
}
