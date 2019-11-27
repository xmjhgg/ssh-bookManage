package dao;

import pojo.User;

public interface UserDao {
	public boolean addNewUser(User user);
	public boolean updateUser(User user);
	public User login(String username,String password);
	
	
	
}
