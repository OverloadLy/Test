package service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.PaperDao;
import model.Paper;

@Service
public class PaperService {
	
	private PaperDao userDao;
	
	@Autowired
	public void setUserDao(PaperDao userDao) {
		this.userDao = userDao;
	}

	public List<Paper> findPaper() {
		
		return userDao.findPaper();
	}
	
	public void addPoint(int id,int score){
		userDao.addPoint(id, score);
	}
	
	
	
}
