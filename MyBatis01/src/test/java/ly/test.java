package ly;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cqust.dao.UserMapper;
import com.cqust.model.User;
import com.cqust.service.UserService;

public class test {
	
	@Test
	public void t() {
		 ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserMapper userMapper=context.getBean(UserMapper.class);
		/* List<User>users=userMapper.findAll();
		 for (User user : users) {
			System.out.println(user);
		}*/
		 
		/*User user=new User();
		user.setName("haha");
		userMapper.insert(user);*/
		 
		/*User user=userMapper.findOne(1);
		System.out.println(user);*/
		 
		UserService service=context.getBean(UserService.class);
		List<User> user=service.findAll();
		for (User user2 : user) {
			System.out.println(user);
		}
		
	}
}
