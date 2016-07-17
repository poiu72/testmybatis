package mybatis.service;

import mybatis.model.UserEntity;

/**
 * Created by jiaranran on 2016/7/14.
 */
public class MyUserDetailService implements UserDetailService {
    @Override
    public UserEntity loadUserByUsername(String username) {
        return null;
    }
}
