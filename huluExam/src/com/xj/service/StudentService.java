package com.xj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xj.dao.StudentDao;
import com.xj.entity.Manage;
import com.xj.entity.PageBean;
import com.xj.entity.Student;

@Transactional
public class StudentService {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Student login(Student student) {
		
		return studentDao.login(student);
	}

	public Student findById(String stuid) {
		
		return studentDao.findById(stuid);
	}

	public void update(Student student) {
		studentDao.update(student);
		
	}

	public List<Student> findAll() {
		
		return studentDao.findAll();
	}

	public List<Student> moreCondition(Student student) {
		
		return studentDao.moreCondittion(student);
	}

	public void deleteStudent(Student student) {
		studentDao.deleteStudent(student);
		
	}

	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
		
	}

	public PageBean listpage(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = studentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//每页显示记录数
		int pageSize = 3;
		
		//总页数
		//总记录数 除以每页显示记录数
		int totalPage = 0;
		if(totalCount%pageSize==0) {
			totalPage = totalCount/pageSize;
		}else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1)*pageSize;
		
		//每页记录的list集合
		List<Student> list = studentDao.findPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
}
