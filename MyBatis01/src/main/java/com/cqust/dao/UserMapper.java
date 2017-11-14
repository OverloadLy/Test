package com.cqust.dao;

import java.util.List;
import com.cqust.model.User;

public interface UserMapper {
	
	public User login(String name,String pass);
	public void addUser(User user);
	public List<User> findAll();
	public User findOne(int id);
	public void insert(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public List<User> findUsesrByPage(int startPos, int pageSize);
	public int getUsersCount(); 
}
