package com.xj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xj.entity.Manage;
import com.xj.entity.Student;
import com.xj.service.ManageService;
import com.xj.service.StudentService;

public class ManageAction extends ActionSupport implements ModelDriven<Manage>{
	private ManageService manageSerivce;
	private String mainPage;
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public void setManageSerivce(ManageService manageSerivce) {
		this.manageSerivce = manageSerivce;
	}
	private Manage manage = new Manage();
	public Manage getModel() {
		
		return manage;
	}
	
	//����Ա��¼
	public String login() {
		Manage currentUser = manageSerivce.login(manage);
		if(currentUser != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			request.getSession().setAttribute("currentUser", currentUser);
			return "loginsuccess";
		}
		return "login";
	}
	
	//��������Ϣ��
	public String studentList() {
		
		return SUCCESS;
		
	}
	
	//��������ѯ����
	public String moreCondition() {
		//List<Manage> list = studentService.moreCondition(manage);
		return "moreCondition";
	}

}
