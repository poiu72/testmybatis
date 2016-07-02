package sy.dao;

import sy.model.User;
import sy.model.UserCustom;
import sy.model.UserQueryVo;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User findUserByName(String name);
    List<UserCustom> findUserList(UserQueryVo userQueryVo);
    List<User> getAll();
	List<User> getAll2();

	List<User> getAll3();
	List<User> getAll4();

    int selectCount( UserQueryVo userQueryVo);
}