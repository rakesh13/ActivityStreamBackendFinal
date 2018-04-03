package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.UserMessageDao;
import com.stackroute.ActivityStreamBackend.model.UserMessage;
//import com.stackroute.ActivityStreamBackend.model.UserCircle;




@Repository(value="userMessageDao")
@Component
@Transactional
public class UserMessageDaoImpl implements UserMessageDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean sendMessage(UserMessage usrmessage) {
		try
		{
			sessionFactory.getCurrentSession().save(usrmessage);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}

	public boolean deleteMessage(int messageId) {
		UserMessage userMessage=(UserMessage) sessionFactory.getCurrentSession().createCriteria(UserMessage.class).add(Restrictions.eq("messageId", messageId)).uniqueResult();
		if(userMessage!=null)
		{
			sessionFactory.getCurrentSession().delete(userMessage);
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<UserMessage> getMyMessages(String emailId) {
		return sessionFactory.getCurrentSession().createCriteria(UserMessage.class).add(Restrictions.eq("senderEmailId", emailId)).list();
		
	}

	@Override
	public List<UserMessage> getAllMessageByCircleName(String circleName) {
		if(isCircleExists(circleName))
		{
		String hql="from com.stackroute.ActivityStreamBackend.model.UserMessage where circleName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, circleName);
		
		List<UserMessage> messageList= query.list();
		return messageList;
		}
		else
		{
			return null;
		}

	}
	
	@Override
	public List<UserMessage> getAllMessageByUsers(String senderEmailId, String receiverEmailId) {
		
		System.out.println("Sender Mail ID "+senderEmailId);
		System.out.println("Receiver Mail ID "+receiverEmailId);
		String hql="from com.stackroute.ActivityStreamBackend.model.UserMessage where senderEmailId= ? and receiverEmailId= ? or senderEmailId= ? and receiverEmailId= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setString(0, senderEmailId).setString(1, receiverEmailId).setString(2, receiverEmailId).setString(3, senderEmailId);
		//return sessionFactory.getCurrentSession().createCriteria(UserMessage.class).add(Restrictions.eq("senderEmailId",senderEmailId)).add(Restrictions.eq("receiverEmailId",receiverEmailId)).list();
		List<UserMessage> messageList= query.list();
		
		return messageList;
	}
		

	
	
	
	

	@Override
	public boolean isReceiverExists(String receiverEmailId) {
		String hql="FROM User where emailId='"+receiverEmailId+"'";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		if(query.list().size()>0)
			return true;
		else
			return false;

	}

	@Override
	public boolean isCircleExists(String circleName) {
		String hql = "from com.stackroute.ActivityStreamBackend.model.UserCircle where circleName='"+circleName+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		
		if (query != null)
			return true;
		else
			return false;

	}

}
