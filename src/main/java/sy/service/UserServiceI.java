package sy.service;

import java.util.List;

import sy.model.User;

public interface UserServiceI {
	public User getUserById(String id);
	public List<User> getAll();
	public List<User> getAll2();

	public List<User> getAll3();
	public List<User> getAll4();
}
