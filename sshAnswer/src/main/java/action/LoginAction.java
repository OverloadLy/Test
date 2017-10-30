package action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import model.Student;
import service.LoginService;

@Component
public class LoginAction {
	
	private String userName;
	private String userPass;
	private String role;
	private LoginService service;
	private Map<String, Object> map = ActionContext.getContext().getSession();
	
	public String execute() {
		if(role.equals("teacher")){
			if(service.loginTea(userName, userPass).size()>0){
				map.put("teaName", userName);
				return "teacherSuccess";
			}
		}else if(role.equals("student")){
			List<Student> student=service.loginStu(userName, userPass);
			if(student.size()>0){
				map.put("stuName", student.get(0));
				return "studentSuccess";
			}
		}
		return "login";	
	}
	
	@Autowired
	public void setService(LoginService service) {
		this.service = service;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	

}
