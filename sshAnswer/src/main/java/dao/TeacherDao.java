package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.Paper;
import model.Student;

@Component
public class TeacherDao {
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addPaper(Paper paper) {
		Session session=sessionFactory.getCurrentSession();
		session.save(paper);	
	}

	//��ȡ�û�������
		public int paperCount(){
			Session session=sessionFactory.getCurrentSession();
			String hql="select count(*) from Paper";
			int Count=Integer.parseInt(session.createQuery(hql).list().get(0).toString());
			return Count;
		}
			
		//��ȡ��ҳ�б�pageno��ʾҳ�룬pagesize��ʾ��ʾ�������м���
		public List<Paper> findAll(int pageNo,int pagesize){
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Paper");
			//�趨����һ�п�ʼ����Ϊ���ݿ���±��Ǵ�0��ʼ��
			query.setFirstResult((pageNo-1)*pagesize);
			//�趨ÿҳ��ʾ�������ж���
			query.setMaxResults(pagesize);
			List<Paper> list=query.list();
				return list;
		}


	public Paper findOne(int id) {
		Session session=sessionFactory.getCurrentSession();
		Paper paper=(Paper) session.get(Paper.class, id);
		return paper;
	}

	public List<Student> findClass(String sclass) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Student where class_=:s";
		Query query=session.createQuery(hql);
		query.setString("s", sclass);
		List<Student> students=query.list();
		return students;
	}

	public void delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		Paper paper=(Paper) session.get(Paper.class, id);
		session.delete(paper);
		return ;
	}

	public void update(Paper paper) {
		Session session=sessionFactory.getCurrentSession();
		Paper paper1=(Paper) session.get(Paper.class, paper.getId());	
		paper1.setTitle(paper.getTitle());
		paper1.setOptionA(paper.getOptionA());
		paper1.setOptionB(paper.getOptionB());
		paper1.setOptionC(paper.getOptionC());
		paper1.setOptionD(paper.getOptionD());
		paper1.setAnswer(paper.getAnswer());
		session.save(paper1);
	}
}
