package sy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import sy.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    User findUserByName(String name);
    List<User> getAll();
	List<User> getAll2();

	List<User> getAll3();
	List<User> getAll4();
}