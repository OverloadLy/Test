package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TeacherDao;
import model.Paper;
import model.Student;

@Service
public class TeacherService {
	
	private TeacherDao tDao;
	
	public void addPaper(Paper paper) {
		tDao.addPaper(paper);
		
	}
	
	@Autowired
	public void settDao(TeacherDao tDao) {
		this.tDao = tDao;
	}
	
	public List<Paper> findAll(int pageNo,int pagesize){
		
		return tDao.findAll(pageNo,pagesize);
	}
	
	public int paperCount(){
		return tDao.paperCount();
	}
	
	public Paper findOne(int id) {
		
		return tDao.findOne(id);
	}

	public List<Student> findClass(String sclass) {
		return tDao.findClass(sclass);
		
	}

	public void delete(int id) {
		 tDao.delete(id);	
	}

	public void update(Paper paper) {
		tDao.update(paper);
		
	}
}
