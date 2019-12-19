package com.xj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Exam;

public class ExamDaoImpl extends HibernateDaoSupport implements ExamDao {

	
	public void saveExam(Exam exam) {
		this.getHibernateTemplate().save(exam);
		
	}

	
	public List<Exam> findById(String id) {
		
		return (List<Exam>) this.getHibernateTemplate().find("from Exam where studentId=?", id);
	}


	
	public List<Exam> findAll() {
		
		return (List<Exam>) this.getHibernateTemplate().find("from Exam");
	}


	
	public List<Exam> moreCondition(Exam exam) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(Exam.class);
//		if(exam.getStudent().getStuid()!=null) {
//			criteria.add(Restrictions.eq("student.stuid", exam.getStudent().getStuid()));
//		}
//		if(exam.getStudent().getStuname()!=null) {
//			criteria.add(Restrictions.like("student.stuname", "%"+exam.getStudent().getStuname()+"%"));
//		}
		//return (List<Exam>) this.getHibernateTemplate().findByCriteria(criteria);
		StringBuffer hql=new StringBuffer("from Exam exam");
		if(exam.getStudent()!=null && exam.getStudent().getStuid()!=null){
			hql.append(" and exam.student.stuid like '%"+exam.getStudent().getStuid()+"%'");
		}
		if(exam.getStudent()!=null&&exam.getStudent().getStuname()!=null){
			hql.append(" and exam.student.stuname like '%"+exam.getStudent().getStuname()+"%'");
		}
		Query query=this.getSessionFactory().getCurrentSession().createQuery(hql.toString().replaceFirst("and", "where"));
		List<Exam> examList=(List<Exam>)query.list();
		return examList;
	}

}
