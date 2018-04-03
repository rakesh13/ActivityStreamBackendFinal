package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.UserCircleDao;
import com.stackroute.ActivityStreamBackend.model.UserCircle;



@Repository(value="userCircleDao")
@Component
@Transactional
public class UserCircleDaoImpl implements UserCircleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUserToCircle(String emailId, String circleName) {
		//check whether user is already added to circle or not
		try
		{
			boolean result=checkUserInCircle(emailId, circleName);
			if(result)
			{
				UserCircle userCircle=new UserCircle();
				userCircle.setCircleName(circleName);
				userCircle.setEmailId(emailId);
				sessionFactory.getCurrentSession().save(userCircle);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	private boolean checkUserInCircle(String emailId, String circleName) {
		UserCircle userCircle=getUserCircle(emailId, circleName);
		if(userCircle==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean deleteUserFromCircle(String emailId, String circleName) {
		try
		{
			UserCircle userCircle=getUserCircle(emailId,circleName);
			if(userCircle!=null)
			{
				sessionFactory.getCurrentSession().delete(userCircle);
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		return false;
	}

	private UserCircle getUserCircle(String emailId,String circleName) {
		try
		{
			String hql="from UserCircle where circleName= '" + circleName +"'and emailId = '" + emailId+"'";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			UserCircle userCircle=(UserCircle) query.uniqueResult();
			return userCircle;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	}

	public List<String> getUsersOfCircle(String circleName) {//getUsersofCircle
		List<String> emailIdList=new ArrayList<String>();
		List<UserCircle> userCircleList=new ArrayList<UserCircle>();
		try
		{
			String hql="from UserCircle where circleName= '" + circleName +"'";//select emailid
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			userCircleList=query.list();
			for(UserCircle userCircle:userCircleList)
			{
				emailIdList.add(userCircle.getEmailId());
			}
			return emailIdList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	}

}
