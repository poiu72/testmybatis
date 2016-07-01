package mybatis.dao;

import mybatis.model.User;

/**
 * Created by jiaranran on 2016/6/30.
 */
public interface UserDao {

        User selectByPrimaryKey(Integer id);
}
