package com.xj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xj.dao.PaperDao;
import com.xj.entity.Paper;

@Transactional
public class PaperService {
	private PaperDao paperDao;

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}

	public List<Paper> findAll() {
		
		return paperDao.findAll();
	}

	public Paper findPaper(int pid) {
		
		return paperDao.findPaper(pid);
	}

	public void savePaper(Paper paper) {
		paperDao.savePaper(paper);
		
	}

	public void deletePaper(Paper p) {
		paperDao.deletePaper(p);
		
	}

	public void addPaper(Paper paper) {
		paperDao.addPaper(paper);
		
	}
	
}
