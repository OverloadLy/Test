package action;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import model.Manager;
import model.Page;
import model.User;
import service.UserService;

@Component
public class UserAction implements ModelDriven<User>{
	
	private User user=new User();
	private Page page=new Page();
	private Manager manager=new Manager();
	private UserService uService;
	private Map<String, Object> map = ActionContext.getContext().getSession();
	List<User>users=null;
	
	/**
	 * ��֤��½
	 */
	public String login() {
		boolean flag=uService.login(manager.getmName(),manager.getmPass());
		System.out.println(manager.getmName()+manager.getmPass());
		if(flag==true){
			return "loginOk";
		}else{
			return "error";
		}	
	}
	
	/**
	 * ��ҳ��ѯ�����û�
	 */
	public String findAll(){
		//�������
		int Count=uService.userCount();
		//��õ�ǰҳ��
		int pageNo=page.getPageNo();
		page.setTotalCount(Count);
		//��ҳ��
		int totalpage=page.getTotalpage();
		users=uService.findAllUser(pageNo, page.getPagesize());
		map.put("count", Count);
		map.put("pageno", pageNo);
		map.put("totalpage", totalpage);
		return "success";
	}
	/**
	 * ���������û�
	 */
	public String findOne() {
		//�������
		int Count=uService.userCount();
		//��õ�ǰҳ��
		int pageNo=page.getPageNo();
		page.setTotalCount(Count);
		//��ҳ��
		int totalpage=page.getTotalpage();
		users=uService.findByName(user.getUserName(), pageNo,page.getPagesize());
		map.put("count", Count);
		map.put("pageno", pageNo);
		map.put("totalpage", totalpage);
		return "findok";
	}
	
	/**
	 * ����û�
	 */
	public String addUser() {
		uService.addUsers(user);
		return "addok";
	}
	
	/**
	 * �޸��û�
	 */
	public String update() {
		User user1=uService.findById(user.getUserId());
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user1);
		return "update";
	}
	
	/**
	 * �޸��û�
	 */
	public String updateOK() {
		uService.updateUser(user);
		return "updateOK";
	}
	
	/**
	 * ɾ���û�
	 */
	public String delete() {
		uService.deleteUser(user.getUserId());		
		return "delok";
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Autowired
	public void setuService(UserService uService) {
		this.uService = uService;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
