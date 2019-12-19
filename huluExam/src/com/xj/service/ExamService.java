package com.xj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xj.dao.ExamDao;
import com.xj.entity.Exam;

@Transactional
public class ExamService {
	private ExamDao examDao;

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public void saveExam(Exam exam) {
		examDao.saveExam(exam);
		
	}

	public List<Exam> findById(String id) {
		
		return examDao.findById(id);
	}

	public List<Exam> findAll() {
		return examDao.findAll();
	}

	public List<Exam> moreCondition(Exam exam) {
		
		return examDao.moreCondition(exam);
	}
	
}
