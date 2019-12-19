package com.xj.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xj.entity.Paper;
import com.xj.entity.Question;
import com.xj.service.PaperService;

public class PaperAction extends ActionSupport implements ModelDriven<Paper> {
	private String mainPage;
	private PaperService paperService;
	private String title;
	
	private List<Paper> paperList=new ArrayList<Paper>();
	private List<Question> squestionList=new ArrayList<Question>();
	private List<Question> mquestionList=new ArrayList<Question>();
	
	
	public List<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Paper> paperList) {
		this.paperList = paperList;
	}

	public List<Question> getSquestionList() {
		return squestionList;
	}

	public void setSquestionList(List<Question> squestionList) {
		this.squestionList = squestionList;
	}

	public List<Question> getMquestionList() {
		return mquestionList;
	}

	public void setMquestionList(List<Question> mquestionList) {
		this.mquestionList = mquestionList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	private Paper paper = new Paper();
	public Paper getModel() {
		
		return paper;
	}
	
	//到试卷页面
	public String paperList() {
		List<Paper> paperList = paperService.findAll();
		ServletActionContext.getRequest().setAttribute("paperList", paperList);
		mainPage = "paper/paperList.jsp";
		return "paperList";
	}
	
	//到修改页面
	public String preSave() {
		
		int pid = paper.getId();
		Paper p = paperService.findPaper(pid);
		ServletActionContext.getRequest().setAttribute("paper", p);
		
		title = "修改试卷信息";
		mainPage = "paper/paperSave.jsp";
		return SUCCESS;
	}
	
	//修改操作
	public String savePaper() {
		
		paperService.savePaper(paper);
		
		return "savePaper";
	}
	
	public String deletePaper() {
		int pid = paper.getId();
		Paper p = paperService.findPaper(pid);
		if(p != null) {
			paperService.deletePaper(p);
		}
		return "deletePaper";
	}
	
	public String toAddPaper() {
		title = "添加试卷";
		mainPage = "paper/paperSaveA.jsp";
		return SUCCESS;
	}
	
	public String addPaper() {
		paper.setJoinDate(new Date());
		paperService.addPaper(paper);
		return "addPaper";
	}
	
	//选择考试
	public String selectPaper() {
		List<Paper> paperList = paperService.findAll();
		ServletActionContext.getRequest().setAttribute("paperList", paperList);
		mainPage = "exam/selectPaper.jsp";
		return SUCCESS;
	}
	
	public String getDetailPaper()throws Exception{
		int paperId = paper.getId();
		Paper paper = paperService.findPaper(paperId);
		ServletActionContext.getRequest().setAttribute("paper", paper);
		Set<Question> questionList=paper.getSetQuestion();
		Iterator<Question> it=questionList.iterator();
		while(it.hasNext()){
			Question q=it.next();
			if("1".equals(q.getType())){
				squestionList.add(q);
			}else{
				mquestionList.add(q);
			}
		}
		mainPage="exam/paper.jsp";
		return SUCCESS;
	}
	
	

}
