package com.xj.dao;

import java.util.List;

import com.xj.entity.Paper;

public interface PaperDao {

	List<Paper> findAll();

	Paper findPaper(int pid);

	void savePaper(Paper paper);

	void deletePaper(Paper p);

	void addPaper(Paper paper);

}
