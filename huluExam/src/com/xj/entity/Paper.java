package com.xj.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Paper {
	private Integer id;
	private String paperName;
	private Date joinDate;
	
	private Set<Question> setQuestion = new HashSet<Question>();
	private Set<Exam> setExam = new HashSet<Exam>();
	
	public Set<Exam> getSetExam() {
		return setExam;
	}
	public void setSetExam(Set<Exam> setExam) {
		this.setExam = setExam;
	}
	public Set<Question> getSetQuestion() {
		return setQuestion;
	}
	public void setSetQuestion(Set<Question> setQuestion) {
		this.setQuestion = setQuestion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
