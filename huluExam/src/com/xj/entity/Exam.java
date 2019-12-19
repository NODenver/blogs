package com.xj.entity;

import java.util.Date;

/**
 * 考试表
 * @author Administrator
 *
 */
public class Exam {

	private int id;  // 考试编号
	private Student student; // 学生
	private Paper paper; // 试卷
	private int singleScore; // 单选题得分
	private int moreScore; // 多选题得分
	private int score;  // 总得分
	private Date examDate; // 考试时间
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public int getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}
	public int getMoreScore() {
		return moreScore;
	}
	public void setMoreScore(int moreScore) {
		this.moreScore = moreScore;
	}
	
	
}
