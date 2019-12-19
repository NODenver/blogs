package com.xj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xj.entity.PageBean;
import com.xj.entity.Student;
import com.xj.service.StudentService;
import com.xj.util.DateUtil;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private StudentService studentService;
	private String mainPage;
	private String title;
	private Integer currentPage;
	

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
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

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private Student student = new Student();
	public Student getModel() {
		
		return student;
	}

	public String login() {
		Student currentUser = studentService.login(student);
		if(currentUser != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			request.getSession().setAttribute("currentUser", currentUser);
			return "loginsuccess";
		}
		return "login";
	}

	//���޸�����ҳ��
	public String updatePassword() {
		mainPage="student/updatePassword.jsp";
		return SUCCESS;
	}
	
	//�޸�����
	public String afterUpdatePassword() {
		String stuid = student.getStuid();
		Student s = studentService.findById(stuid);
		studentService.update(student);
		mainPage = "student/updateSuccess.jsp";
		return "afterUpdatePassword";
	}
	
	public String studentList() {
		mainPage = "student/studentList.jsp";
		//��ȡ������Ϣ
		//List<Student> studentList = studentService.findAll();
		//ServletActionContext.getRequest().setAttribute("studentList", studentList);
		//����service�ķ���ʵ�ַ�װ
	    PageBean pageBean = studentService.listpage(currentPage);
		//�ŵ����������
		ServletActionContext.getRequest().getSession().setAttribute("pageBean", pageBean);
		return "studentList";
		
	}
	
	//��������ѯ����
		public String moreCondition() {
			currentPage = 1;
			List<Student> studentList = studentService.moreCondition(student);
		    PageBean pageBean = studentService.listpage(currentPage);
		    pageBean.setList(studentList);
		    HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("pageBean", pageBean);
			
			mainPage = "student/studentList.jsp";
			return "moreCondition";
		}
	//���޸�ҳ��
	public String preSave() {
		
		String sid = student.getStuid();
		Student student = studentService.findById(sid);
	    ServletActionContext.getRequest().setAttribute("student", student);
		 
		title="�޸�ѧ����Ϣ";	
		mainPage = "student/studentSave.jsp";
		return SUCCESS;
	}
	
	public String update() {
		studentService.update(student);
		mainPage = "student/studentList.jsp";
		return "update";
	}
	
	//ɾ��ѧ����Ϣ
	public String deleteStudent() {
		String sid = student.getStuid();
		Student student = studentService.findById(sid);
		if(student!=null) {
			studentService.deleteStudent(student);
		}
		
		return "deleteStudent";
	}
	
	//�����ѧ��ҳ��
	public String toAddStudent() {
		mainPage = "student/studentSaveA.jsp";
		title = "���ѧ����Ϣ";
		return SUCCESS;
	}
	
	//���ѧ����Ϣ
	public String saveStudent() throws Exception {
		student.setStuid("JS"+DateUtil.getCurrentDateStr());
		studentService.saveStudent(student);
		return "saveStudent";
	}
	
	//��ҳ����
	public String listPage() {
		
		mainPage = "student/studentList.jsp";
		return "listPage";
	}
}
