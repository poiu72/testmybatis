package mybatis.dao;

import mybatis.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by jiaranran on 2016/6/30.
 */
@Repository
public interface UserDao {

        User selectByPrimaryKey(Integer id);
}
