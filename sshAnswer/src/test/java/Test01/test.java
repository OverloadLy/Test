package Test01;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Paper;
import model.Student;
import service.LoginService;
import service.PaperService;

public class test {
	
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService s=context.getBean(LoginService.class);
		List<Student>list=s.loginStu("ly", "123");
		System.out.println(list.size());
	}
}



