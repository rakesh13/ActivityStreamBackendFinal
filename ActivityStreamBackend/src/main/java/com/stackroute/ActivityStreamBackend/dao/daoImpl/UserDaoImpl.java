package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.UserDao;
import com.stackroute.ActivityStreamBackend.model.User;



@Repository(value="userDao")
@Component
@Transactional
public class UserDaoImpl implements UserDao {


	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	User user;

public UserDaoImpl() {
	// TODO Auto-generated constructor stub
}
	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
	//	log.debug("start");
		this.sessionFactory=sessionFactory;
		
	}

	
	//@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;
	public boolean save(User user) {
		
		try {
			//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setPassword(user.getPassword());
			user.setActive(true);
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean update(User user) {
		
		
		try{
			
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	public User get(String id) {
			
		user =	(User)sessionFactory.getCurrentSession().get(User.class, id);
		
		
				return user;

	}

	
	public List<User> list() {
		
		String hql = "from User";
		
		Query query=  sessionFactory.getCurrentSession().createQuery(hql);
		
		return  query.list();

	}


	public User validate(String id, String password) {
		
		/*//Use Criteria instead of building query manually.
		String hql = "from User  where emailId= '" + id +"' and password = '" + password+"'";
		
		Query query=  sessionFactory.openSession().createQuery(hql);
		
		return  (User) query.uniqueResult();*/
		return null;

	}
}
