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
	 * ��½��֤
	 */
	public boolean login(String userName,String password) {
		
		return userDao.login(userName,password);	
	}
	
    /**
     * ���
     */
	public boolean addUsers(User user) {
		
		return userDao.addUsers(user);	
	}
	
	/**
	 * ɾ���û���Ϣ
	 */
	public boolean deleteUser(int userId) {
	     
		return userDao.deleteUser(userId);
	}
	
	
	/**
	 * �������������û���Ϣ
	 */
	public List<User> findByName(String userName,int pageNo,int pagesize){
		
		return userDao.findByName(userName,pageNo,pagesize);
	}
	
	/**
	 * ����Id�����û���Ϣ
	 */
	public User findById(int userId){
		
		return userDao.findById(userId);
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	public boolean updateUser(User user){
		
		return userDao.updateUser(user);
	}
	
	//��ȡ�û�������
		public int userCount(){		
			return userDao.userCount();
		}
			
			//��ȡ��ҳ�б�pageno��ʾҳ�룬pagesize��ʾ��ʾ�������м���
		public List<User> findAllUser(int pageNo,int pagesize){
			return userDao.findAllUser(pageNo, pagesize);
		}
	
}
