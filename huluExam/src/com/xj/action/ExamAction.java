package com.xj.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xj.entity.Exam;
import com.xj.entity.Question;
import com.xj.service.ExamService;
import com.xj.service.QuestionService;

public class ExamAction extends ActionSupport implements ModelDriven<Exam>{
	private ExamService examService;
	private String mainPage;
	private QuestionService questionService;
	
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	private Exam exam = new Exam();
	public Exam getModel() {
		
		return exam;
	}
	
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> keyMap = new HashMap<String, String[]>();
        keyMap = request.getParameterMap();
        Iterator<Entry<String,String[]>> it2 = keyMap.entrySet().iterator();
        int totalScore=0;
        int singleScore=0;
        int moreScore=0;
        while (it2.hasNext()) {
            Entry<String, String[]> entry = it2.next();  
            String keyStr=entry.getKey();
            String values[]=entry.getValue();
            String key;
            String value="";
            if(keyStr.equals("student.stuid")||keyStr.equals("paper.id")){
            	continue;
            }
            if(keyStr.split("-")[1].equals("r")){  // 单选
            	key=keyStr.split("-")[2];
            	value=values[0];
            	singleScore+=this.calScore(key, value, "1");
            }else{  // 多选
            	key=keyStr.split("-")[2];
            	for(String s:values){
            		value+=s+",";
            	}
            	value=value.substring(0,value.length()-1);
            	moreScore+=this.calScore(key, value, "2");
            }
        }
        totalScore=singleScore+moreScore;
        exam.setSingleScore(singleScore);
        exam.setMoreScore(moreScore);
        exam.setScore(totalScore);
        exam.setExamDate(new Date());
        examService.saveExam(exam);
        request.setAttribute("exam", exam);
		mainPage="exam/examResult.jsp";
		return SUCCESS;
	}
	
	public String queryScore() {
		String id = exam.getStudent().getStuid();
		List<Exam> examList = examService.findById(id);
		ServletActionContext.getRequest().setAttribute("examList", examList);
		mainPage="exam/myExam.jsp";
		return SUCCESS;
	}
	
	public String getStudentScore() {
		List<Exam> examList = examService.findAll();
		ServletActionContext.getRequest().setAttribute("examList", examList);
		mainPage="exam/examList.jsp";
		return SUCCESS;
	}
	
	public String moreCondition() {
		List<Exam> examList = examService.moreCondition(exam);
		ServletActionContext.getRequest().setAttribute("examList", examList);
		mainPage="exam/examList.jsp";
		return "moreCondition";
	}
	
	private int calScore(String questionId,String userAnswer,String type){
		Question question=questionService.getQuestion(questionId);
		if(userAnswer.equals(question.getAnswer())){
			if("1".equals(type)){
				return 20;
			}else{
				return 30;
			}
		}else{
			return 0;
		}
	}

}
