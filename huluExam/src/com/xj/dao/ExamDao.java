package com.xj.dao;

import java.util.List;

import com.xj.entity.Exam;

public interface ExamDao {

	void saveExam(Exam exam);

	List<Exam> findById(String id);

	List<Exam> findAll();

	List<Exam> moreCondition(Exam exam);

}
