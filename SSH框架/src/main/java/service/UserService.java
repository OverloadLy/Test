package service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.UserDao;
import model.Manager;
import model.Page;
import model.User;

@Service
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/***
	 * 登陆验证
	 */
	public boolean login(String userName,String password) {
		
		return userDao.login(userName,password);	
	}
	
    /**
     * 添加
     */
	public boolean addUsers(User user) {
		
		return userDao.addUsers(user);	
	}
	
	/**
	 * 删除用户信息
	 */
	public boolean deleteUser(int userId) {
	     
		return userDao.deleteUser(userId);
	}
	
	
	/**
	 * 根据姓名查找用户信息
	 */
	public List<User> findByName(String userName,int pageNo,int pagesize){
		
		return userDao.findByName(userName,pageNo,pagesize);
	}
	
	/**
	 * 根据Id查找用户信息
	 */
	public User findById(int userId){
		
		return userDao.findById(userId);
	}
	
	/**
	 * 修改用户信息
	 */
	public boolean updateUser(User user){
		
		return userDao.updateUser(user);
	}
	
	//获取用户总数量
		public int userCount(){		
			return userDao.userCount();
		}
			
			//获取分页列表，pageno表示页码，pagesize表示显示的行数有几行
		public List<User> findAllUser(int pageNo,int pagesize){
			return userDao.findAllUser(pageNo, pagesize);
		}
	
}
