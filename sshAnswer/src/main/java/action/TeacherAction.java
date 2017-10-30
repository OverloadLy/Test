package action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import model.Page;
import model.Paper;
import model.Student;
import service.TeacherService;

@Component
public class TeacherAction implements ModelDriven<Paper> {
	
	private Paper paper=new Paper();
	private Page page=new Page();
	private TeacherService tService;
	private List<Paper> papers;
	private String class_;
	private Map<String, Object> map = ActionContext.getContext().getSession();

	public String add() {
		tService.addPaper(paper);
		findPage();
		return "addOk";	
	}
	
	public void findPage() {
		// 获得总数
		int Count = tService.paperCount();
		// 获得当前页码
		int pageNo = page.getPageNo();
		page.setTotalCount(Count);
		// 总页数
		int totalpage = page.getTotalpage();
		papers = tService.findAll(pageNo, page.getPagesize());
		map.put("count", Count);
		map.put("pageno", pageNo);
		map.put("totalpage", totalpage);
	}
	
	public String findAll() {
	    findPage();
		return "findAll";
	}
	
	public String findOne() {
		paper=tService.findOne(paper.getId());
		map.put("subject", paper);
		return "findOne" ;
		
	}
	
	public String findClass() {
		List<Student> students=tService.findClass(class_);
		map.put("students", students);
		return "findClass";
	}

	public String update() {
		tService.update(paper);
		findPage();
		return "findAll";
	}

	public String delete() {
		tService.delete(paper.getId());
		findPage();
		return "findAll";
	}
	
	@Autowired
	public void settService(TeacherService tService) {
		this.tService = tService;
	}

	public Paper getModel() {
		// TODO Auto-generated method stub
		return paper;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
