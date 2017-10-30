package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.Student;
import model.Teacher;

@Component
public class LoginDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Student> loginStu(String name,String pass) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Student where sName=:name and sPass=:pass";
		Query query=session.createQuery(hql);
		query.setString("name", name);
		query.setString("pass", pass);
		List<Student> students=query.list();
		return students;
	}
	
	public List<Teacher> loginTea(String name,String pass) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Teacher where tName=:name and tPass=:pass";
		Query query=session.createQuery(hql);
		query.setString("name", name);
		query.setString("pass", pass);
		List<Teacher> teachers=query.list();
		return teachers;
		
	}
}
