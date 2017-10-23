package com.cqust.dao;


import org.springframework.stereotype.Component;
import com.cqust.model.User;

@Component
public class UserDao {
	public User getUser(int id) {
		User user=new User();
		user.setId(1);
		user.setName("ว๋สตัต");
		user.setAge(18);
		return user;
	}
}
