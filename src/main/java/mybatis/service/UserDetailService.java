package mybatis.service;

import mybatis.model.UserEntity;

/**
 * Created by jiaranran on 2016/7/14.
 */
public interface UserDetailService {
    public UserEntity loadUserByUsername(String username);
}
