package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.LoginDao;
import model.Student;
import model.Teacher;

@Service
public class LoginService {
	
	private LoginDao lDao;
	
	public List<Student> loginStu(String name,String pass) {
		return lDao.loginStu(name, pass);
	}
	public List<Teacher> loginTea(String name,String pass) {
		return lDao.loginTea(name, pass);
	}

	@Autowired
	public void setlDao(LoginDao lDao) {
		this.lDao = lDao;
	}
}
