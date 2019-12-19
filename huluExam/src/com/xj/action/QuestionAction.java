package com.xj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xj.entity.Paper;
import com.xj.entity.Question;
import com.xj.service.PaperService;
import com.xj.service.QuestionService;

public class QuestionAction extends ActionSupport implements ModelDriven<Question>{
	private PaperService paperService;
	
	
	
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	private String mainPage;
	private String title;
	
	
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
	public void setQuestion(Question question) {
		this.question = question;
	}
	private Question question = new Question();
	public Question getModel() {
		
		return question;
	}
	
	//到题目信息页面
	public String questionList() {
		List<Question> questionList = questionService.findAll();
		ServletActionContext.getRequest().setAttribute("questionList", questionList);
		mainPage = "question/questionList.jsp";
		return "questionList";
	}
	
	//到添加题目页面
	public String addQuestion() {
		List<Paper> paperList = paperService.findAll();
		ServletActionContext.getRequest().setAttribute("paperList", paperList);
		title = "添加题目内容";
		mainPage = "question/questionSave.jsp";
		return SUCCESS;
	}
	
	//保存题目信息
	public String saveQuestion() {
		questionService.saveQuestion(question);
		return "saveQuestion";
	}
	
	//到查看题目界面
	public String getQuestionById() {
		int questionId = question.getId();
		Question questionList = questionService.findById(questionId);
		ServletActionContext.getRequest().setAttribute("questionList", questionList);
		mainPage = "question/questionShow.jsp";
		return SUCCESS;
	}
	
	//到修改试题页面
	public String preSave() {
		int questionId = question.getId();
		List<Paper> paperList = paperService.findAll();
		
		Question question = questionService.findById(questionId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("question", question);
		request.setAttribute("paperList", paperList);
		title = "修改题目内容";
		mainPage = "question/questionSaveA.jsp";
		return SUCCESS;
	}
	
	//更改题目信息
	public String updateQuestion() {
		questionService.updateQuestion(question);
		return "updateQuestion";
	}
	
	//删除题目信息
	public String deleteQuestion() {
		int questionId = question.getId();
		Question question = questionService.findById(questionId);
		if(question != null) {
			questionService.deleteQuestion(question);
		}
		return "deleteQuestion";
	}
	
	//条件查询
	public String condition() {
		if(question.getSubject()!=null && !"".equals(question.getSubject())) {
			mainPage = "question/questionList.jsp";
			List<Question> questionList = questionService.condition(question);
			ServletActionContext.getRequest().setAttribute("questionList", questionList);
		}else {
			questionList();
		}
		return "condition";
	}

}
