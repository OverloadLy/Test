package com.cqust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cqust.dao.UserDao;
import com.cqust.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao uDao;
	
	public User getUser(int id){
		return uDao.getUser(id );
	}
}
