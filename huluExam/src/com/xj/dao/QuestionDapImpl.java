package com.xj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Question;

public class QuestionDapImpl extends HibernateDaoSupport implements QuestionDao {

	//查询所有
	public List<Question> findAll() {
		
		return (List<Question>) this.getHibernateTemplate().find("from Question");
	}

	//添加题目
	public void saveQuestion(Question question) {
		this.getHibernateTemplate().save(question);
		
	}

	//根据ID查询
	public Question findById(int questionId) {
		
		return  this.getHibernateTemplate().get(Question.class, questionId);
	}

	//更新题目
	public void updateQuestion(Question question) {
		this.getHibernateTemplate().update(question);
		
	}

	//删除题目
	public void deleteQuestion(Question question) {
		this.getHibernateTemplate().delete(question);
		
	}

	//条件查询
	public List<Question> condition(Question question) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.like("subject", "%"+question.getSubject()+"%"));
		List<Question> list = (List<Question>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	
	public Question getQuestion(String questionId) {

		Session session = this.getSessionFactory().getCurrentSession();		
		Question question=(Question) session.get(Question.class, Integer.parseInt(questionId));
		
		return question;
	}

}
