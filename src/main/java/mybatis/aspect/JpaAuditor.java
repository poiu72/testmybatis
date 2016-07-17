package mybatis.aspect;

import mybatis.model.UserEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by jiaranran on 2016/7/14.
 */
@Component
public class JpaAuditor implements AuditorAware<UserEntity> {

    private UserEntity userEntity;
    @Override
    public UserEntity getCurrentAuditor() {
        return userEntity;
    }
    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
