package sy.service;

import sy.model.User;

import java.util.List;

public interface UserServiceI {
	public User getUserById(String id);
	public List<User> getAll();
	public List<User> getAll2();

	public List<User> getAll3();
	public List<User> getAll4();
}
