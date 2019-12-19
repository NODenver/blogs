package com.xj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Manage;
import com.xj.entity.Student;


public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	//��¼����
	public Student login(Student student) {
		List<Student> list = 
				(List<Student>) this.getHibernateTemplate()
				.find("from Student where stuid=? and stupassword=?", student.getStuid(),student.getStupassword());
		if(list != null && list.size()!=0) {
			Student s = list.get(0);
			return s;
		}
		return null;
		
	}

	//����ID��ѯ
	public Student findById(String stuid) {
		
		return this.getHibernateTemplate().get(Student.class, stuid);
	}

	//�޸Ĳ���
	public void update(Student student) {
		this.getHibernateTemplate().update(student);
		
	}

	//��ѯ����
	public List<Student> findAll() {
		
		return (List<Student>) this.getHibernateTemplate().find("from Student");
	}

	//��������ѯ
	public List<Student> moreCondittion(Student student) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		if(student.getStuid()!=null) {
			//criteria.add(Restrictions.eq("stuid", student.getStuid()));
			criteria.add(Restrictions.like("stuid", "%"+student.getStuid()+"%"));
		}
		if(student.getStuname()!=null) {
			//criteria.add(Restrictions.eq("stuname", student.getStuname()));
			criteria.add(Restrictions.like("stuname", "%"+student.getStuname()+"%"));
		}
		
		return (List<Student>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	//ɾ������
	public void deleteStudent(Student student) {
		this.getHibernateTemplate().delete(student);
		
	}

	//���ѧ����Ϣ
	public void saveStudent(Student student) {
		this.getHibernateTemplate().save(student);
		
	}

	//��ѯ��¼��
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Student");
		if(list != null&& list.size()!=0) {
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//��ҳ��ѯ
	public List<Student> findPage(int begin, int pageSize) {
		//�������߶������ö��ĸ�����в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		//����hibernateTemplate�ķ���ʵ��
		List<Student> list = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
}
