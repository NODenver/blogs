package com.xj.dao;

import java.util.List;

import com.xj.entity.Manage;
import com.xj.entity.Student;

public interface StudentDao {

	Student login(Student student);

	Student findById(String stuid);

	void update(Student student);

	List<Student> findAll();

	List<Student> moreCondittion(Student student);

	void deleteStudent(Student student);

	void saveStudent(Student student);

	int findCount();

	List<Student> findPage(int begin, int pageSize);

}
