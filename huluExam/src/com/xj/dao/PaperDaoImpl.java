package com.xj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Paper;

public class PaperDaoImpl extends HibernateDaoSupport implements PaperDao {

	//查询所有
	public List<Paper> findAll() {
		
		return (List<Paper>) this.getHibernateTemplate().find("from Paper");
	}

	//根据ID查询
	public Paper findPaper(int pid) {
		
		return this.getHibernateTemplate().get(Paper.class, pid);
	}

	//修改
	public void savePaper(Paper paper) {
		this.getHibernateTemplate().update(paper);
		
	}

	//删除
	public void deletePaper(Paper p) {
		this.getHibernateTemplate().delete(p);
		
	}

	//添加
	public void addPaper(Paper paper) {
		this.getHibernateTemplate().save(paper);
		
	}

}
