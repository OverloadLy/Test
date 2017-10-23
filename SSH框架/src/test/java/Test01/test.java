package Test01;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.UserDao;
import model.Manager;
import model.User;
import service.UserService;

public class test {
	
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=context.getBean(UserService.class);	
	}
}



