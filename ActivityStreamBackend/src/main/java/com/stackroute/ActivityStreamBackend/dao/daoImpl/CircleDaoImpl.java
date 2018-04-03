package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.CircleDao;
import com.stackroute.ActivityStreamBackend.model.Circle;
import com.stackroute.ActivityStreamBackend.model.Message;



@Repository(value="circleDao")
@Component
@Transactional
public class CircleDaoImpl implements CircleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CircleDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public CircleDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean addCircle(Circle circle) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(circle);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public List<Circle> getAllCircles() {
		
		return sessionFactory.getCurrentSession().createQuery("from Circle where status=true").list();
	}
	public List<Circle> getCircleByUser(String emailId) {
		try
		{
			String hql="from Circle where createdBy= '" + emailId +"'";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	}
	@Override
	public boolean deleteCircle(String emailId, String circleName) {
		try
		{
			List<Circle> circles=getCircleByUser(emailId);
			
			circles.forEach((Circle circle)->{
				Circle circleByName=getCircleByName(circleName);
				if(circle.getCircleName().equals(circleName) && circleByName!=null)
				{
					sessionFactory.getCurrentSession().delete(circleByName);
					
				}
			});
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	@Override
	public Circle getCircleByName(String circleName) {
		return (Circle) sessionFactory.getCurrentSession().createCriteria(Circle.class).add(Restrictions.eq("circleName", circleName));
		//return null;
	}
	

}
