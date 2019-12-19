package com.xj.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String stuid;
	private String stuname;
	private String stupassword;
	private String flag = "2";
	private Set<Exam> setExam = new HashSet<Exam>();
	
	public Set<Exam> getSetExam() {
		return setExam;
	}
	public void setSetExam(Set<Exam> setExam) {
		this.setExam = setExam;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
