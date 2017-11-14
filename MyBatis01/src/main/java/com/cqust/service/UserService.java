package com.cqust.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.cqust.dao.UserMapper;
import com.cqust.model.Page;
import com.cqust.model.User;

@Component
public class UserService {
	
	@Autowired
	private UserMapper uMapper;
	
	/**
	 * ��½��֤
	 */
	public User login(String name,String pass){
		return uMapper.login(name, pass);
	}
	
	/**
	 * ���
	 */
	public void addUser(User user){
		 uMapper.addUser(user);
	}
	
	/**
	 * ��ѯ����
	 */
	public List<User> findAll(){
		return uMapper.findAll();
	}
	
	/**
	 * id��ѯ
	 */	
	public User findOne(int id){
		return uMapper.findOne(id);
	}
	
	/**
	 * ����
	 */
	public void insert(User user){
		 uMapper.insert(user);
	}
	
	/**
	 * ɾ��
	 */
	public void deleteUser(int id){
		uMapper.deleteUser(id);
	}
	
	/**
	 * �޸�
	 */
	public void updateUser(User user){
		uMapper.updateUser(user);
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	public void findUserByPage(Model model,int pageNow){  
	    Page page = null; 
	    List<User> users = new ArrayList<User>();   
	    int totalCount = uMapper.getUsersCount();  
	    if (pageNow != 0) {  
	        page = new Page(totalCount, pageNow);  
	        users = uMapper.findUsesrByPage(page.getStartPos(),page.getPageSize());
	    } else {  
	        page = new Page(totalCount, 1);  
	        users = uMapper.findUsesrByPage(page.getStartPos(), page.getPageSize());  
	    }  	  
	    model.addAttribute("users", users);  
	    model.addAttribute("page", page); 
	}
	
	public int getUsersCount(){
		return uMapper.getUsersCount();
		
	}
}
