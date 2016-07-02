package sy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sy.dao.UserMapper;
import sy.model.User;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserServiceI{
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
//	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		System.out.println("getUserById start---");
		return userMapper.selectByPrimaryKey(Integer.parseInt(id));
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}
	@Override
	public List<User> getAll2() {
		// TODO Auto-generated method stub
		return userMapper.getAll2();
	}
	@Override
	public List<User> getAll3() {
		// TODO Auto-generated method stub
		return userMapper.getAll3();
	}
	@Override
	public List<User> getAll4() {
		// TODO Auto-generated method stub
		return userMapper.getAll4();
	}

}
