package mybatis.dao;

import mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by jiaranran on 2016/6/30.
 */

public class UserDaoImp extends SqlSessionDaoSupport implements UserDao {

    @Override
    public User selectByPrimaryKey(Integer id) {
        SqlSession sqlSession=this.getSqlSession();
        User user=sqlSession.selectOne("mybatis.dao.UserMapper.selectByPrimaryKey", id);
        return user;
    }
}
