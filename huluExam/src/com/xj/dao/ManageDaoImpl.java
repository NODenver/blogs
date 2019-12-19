package com.xj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Manage;


public class ManageDaoImpl extends HibernateDaoSupport implements ManageDao{

	//µÇÂ¼
	public Manage login(Manage manage) {
		
		List<Manage> list = 
				(List<Manage>) this.getHibernateTemplate()
				.find("from Manage where stuname=? and mpassword=?", manage.getStuname(),manage.getMpassword());
		if(list != null && list.size()!=0) {
			Manage m = list.get(0);
			return m;
		}
		return null;
	}

}
