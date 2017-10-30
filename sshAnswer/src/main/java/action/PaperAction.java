package action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.Paper;
import service.PaperService;

@Component
public class PaperAction {
	
	private List<Paper> papers;
	private PaperService uService;
	private List<String> answer;
	private int id;

	@Autowired
	public void setuService(PaperService uService) {
		this.uService = uService;
	}
	
	public String begin(){
		papers=uService.findPaper();
		return "index";
	}
	
	public String saveAnswer() {
		int total=0;
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> studentAnswers = new ArrayList<String>();
		for(int i = 0; i < answer.size(); i++) {
			String sanstuwer = request.getParameter("subjectAnswer"+i);
			studentAnswers.add(sanstuwer);
		}
		for (int i = 0; i < answer.size(); i++) {
			if(answer.get(i).equals(studentAnswers.get(i))){
				total+=10;
			}
		}
		request.setAttribute("point", total);
		uService.addPoint(id, total);
		return "result";	
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
