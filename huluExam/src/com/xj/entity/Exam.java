package com.xj.entity;

import java.util.Date;

/**
 * ���Ա�
 * @author Administrator
 *
 */
public class Exam {

	private int id;  // ���Ա��
	private Student student; // ѧ��
	private Paper paper; // �Ծ�
	private int singleScore; // ��ѡ��÷�
	private int moreScore; // ��ѡ��÷�
	private int score;  // �ܵ÷�
	private Date examDate; // ����ʱ��
	

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
