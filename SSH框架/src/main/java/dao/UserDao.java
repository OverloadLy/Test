package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.Manager;
import model.User;

@Component
public class UserDao {
	
	private SessionFactory sessionFactory;

	/**
	 * 登陆验证
	 */
	public boolean login(String userName,String password) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Manager m where m.mName=:name and m.mPass=:pass";
		Query query=session.createQuery(hql);
		query.setString("name", userName);
		query.setString("pass", password);
		List<Manager> list=query.list();
		if(list.size()>0){
			return true;
		}
		return false;	
	}
	
	/**
	 * 添加用户信息
	 */
	public boolean addUsers(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return true;	
	}
	
	/**
	 * 删除用户信息
	 */
	public boolean deleteUser(int userId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="Delete FROM User Where userId=:id";     
        Query query=session.createQuery(hql);     
        query.setInteger("id",userId) ;     
        query.executeUpdate() ;  
		return true;
	}
	
	/**
	 * 根据姓名查找用户信息
	 */
	public List<User> findByName(String userName,int pageNo,int pagesize){
		Session session=sessionFactory.getCurrentSession();
		String hql="from User u where u.userName=:name";
		Query query=session.createQuery(hql);     
	    query.setString("name",userName);  
	    //设定从哪一行开始，因为数据库的下标是从0开始的
	  	query.setFirstResult((pageNo-1)*pagesize);
	  	//设定每页显示的数据有多少
	  	query.setMaxResults(pagesize);
	  	List<User> list=query.list();
	  	return list;
	}
	
	/**
	 * 根据userId查找用户信息
	 */
	public User findById(int userId){
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class, userId);
		return user;
	}
	/**
	 * 修改
	 */
	public boolean updateUser(User user){
		Session session=sessionFactory.getCurrentSession();
		String hql="update User set userName=:name,userEmail=:email,userSex=:sex,createDate=:cdate,updateDate=:udate where userId=:id";
		Query query=session.createQuery(hql);     
	    query.setString("name",user.getUserName());  
	    query.setString("email",user.getUserEmail()); 
	    query.setString("sex",user.getUserSex()); 
	    query.setDate("cdate",user.getCreateDate()); 
	    query.setDate("udate",user.getUpdateDate()); 
	    query.setInteger("id",user.getUserId()); 
	    query.executeUpdate();
		return true;
	}
	
	//获取用户总数量
	public int userCount(){
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from User";
		int Count=Integer.parseInt(session.createQuery(hql).list().get(0).toString());
		return Count;
	}
		
	//获取分页列表，pageno表示页码，pagesize表示显示的行数有几行
	public List<User> findAllUser(int pageNo,int pagesize){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User");
		//设定从哪一行开始，因为数据库的下标是从0开始的
		query.setFirstResult((pageNo-1)*pagesize);
		//设定每页显示的数据有多少
		query.setMaxResults(pagesize);
		List<User> list=query.list();
			return list;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
