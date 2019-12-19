package com.xj.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.xj.dao.QuestionDao;
import com.xj.entity.Question;


@Transactional
public class QuestionService {
	private QuestionDao questionDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public List<Question> findAll() {
		
		return questionDao.findAll();
	}

	public void saveQuestion(Question question) {
		questionDao.saveQuestion(question);
		
	}

	public Question findById(int questionId) {
		
		return questionDao.findById(questionId);
	}

	public void updateQuestion(Question question) {
		questionDao.updateQuestion(question);
		
	}

	public void deleteQuestion(Question question) {
		questionDao.deleteQuestion(question);
		
	}

	public List<Question> condition(Question question) {
		
		return questionDao.condition(question);
	}
	
	public Question getQuestion(String questionId){

		return questionDao.getQuestion(questionId);
	}
 
}
