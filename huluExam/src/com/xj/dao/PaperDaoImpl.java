package com.xj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Paper;

public class PaperDaoImpl extends HibernateDaoSupport implements PaperDao {

	//��ѯ����
	public List<Paper> findAll() {
		
		return (List<Paper>) this.getHibernateTemplate().find("from Paper");
	}

	//����ID��ѯ
	public Paper findPaper(int pid) {
		
		return this.getHibernateTemplate().get(Paper.class, pid);
	}

	//�޸�
	public void savePaper(Paper paper) {
		this.getHibernateTemplate().update(paper);
		
	}

	//ɾ��
	public void deletePaper(Paper p) {
		this.getHibernateTemplate().delete(p);
		
	}

	//���
	public void addPaper(Paper paper) {
		this.getHibernateTemplate().save(paper);
		
	}

}
