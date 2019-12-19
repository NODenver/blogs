package com.xj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Question;

public class QuestionDapImpl extends HibernateDaoSupport implements QuestionDao {

	//��ѯ����
	public List<Question> findAll() {
		
		return (List<Question>) this.getHibernateTemplate().find("from Question");
	}

	//�����Ŀ
	public void saveQuestion(Question question) {
		this.getHibernateTemplate().save(question);
		
	}

	//����ID��ѯ
	public Question findById(int questionId) {
		
		return  this.getHibernateTemplate().get(Question.class, questionId);
	}

	//������Ŀ
	public void updateQuestion(Question question) {
		this.getHibernateTemplate().update(question);
		
	}

	//ɾ����Ŀ
	public void deleteQuestion(Question question) {
		this.getHibernateTemplate().delete(question);
		
	}

	//������ѯ
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
