package com.xj.dao;

import java.util.List;

import com.xj.entity.Question;

public interface QuestionDao {

	List<Question> findAll();

	void saveQuestion(Question question);

	Question findById(int questionId);

	void updateQuestion(Question question);

	void deleteQuestion(Question question);

	List<Question> condition(Question question);

	Question getQuestion(String questionId);

}
