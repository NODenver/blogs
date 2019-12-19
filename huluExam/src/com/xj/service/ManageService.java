package com.xj.service;

import org.springframework.transaction.annotation.Transactional;

import com.xj.dao.ManageDao;
import com.xj.entity.Manage;

@Transactional
public class ManageService {
	private ManageDao manageDao;

	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}

	public Manage login(Manage manage) {
		
		return manageDao.login(manage);
	}
	
}
