package com.xj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xj.entity.Manage;
import com.xj.entity.Student;


public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	//登录功能
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

	//根据ID查询
	public Student findById(String stuid) {
		
		return this.getHibernateTemplate().get(Student.class, stuid);
	}

	//修改操作
	public void update(Student student) {
		this.getHibernateTemplate().update(student);
		
	}

	//查询所有
	public List<Student> findAll() {
		
		return (List<Student>) this.getHibernateTemplate().find("from Student");
	}

	//多条件查询
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

	//删除功能
	public void deleteStudent(Student student) {
		this.getHibernateTemplate().delete(student);
		
	}

	//添加学生信息
	public void saveStudent(Student student) {
		this.getHibernateTemplate().save(student);
		
	}

	//查询记录数
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

	//分页查询
	public List<Student> findPage(int begin, int pageSize) {
		//创建离线对象，设置对哪个类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		//调用hibernateTemplate的方法实现
		List<Student> list = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
}
