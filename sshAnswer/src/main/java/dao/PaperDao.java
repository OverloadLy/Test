package dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Paper;
import model.Student;

@Component
public class PaperDao {
	
	private SessionFactory sessionFactory;


	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Paper> findPaper() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Paper ORDER BY RAND()");
		query.setMaxResults(10); 
		List<Paper> papers=query.list();
		return papers;
	}
	
	public void addPoint(int id,int score){
		Session session=sessionFactory.getCurrentSession();
		Student student=(Student) session.get(Student.class, id);
		student.setScore(score);
	}
}
