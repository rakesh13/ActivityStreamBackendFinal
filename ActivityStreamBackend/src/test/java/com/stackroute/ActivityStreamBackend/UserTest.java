package com.stackroute.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.ActivityStreamBackend.App;
import com.stackroute.ActivityStreamBackend.dao.UserDao;
import com.stackroute.ActivityStreamBackend.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=App.class)
@EnableAspectJAutoProxy
public class UserTest {

	@Autowired
	private  User user;
	@Autowired
	private  UserDao userDao;
	
	@Ignore
	@Test
	public void saveUser()
	{
		user.setName("rakesh");
		user.setPassword("india");
		user.setEmailId("rakesh@gmail.com");
		user.setPhoneNo("8260579885");
		user.setActive(true);
		assertEquals(true, userDao.save(user));
	}
	
	 @Ignore
		@Test
		public void validateUser()
		{
			User validatedUser=userDao.validate("rakesh@gmail.com","india");
			assertNotNull(validatedUser);
		}
	 @Ignore
		@Test
		public void validateUserByWrongPassword()
		{
			User validatedUser=userDao.validate("rakesh@gmail.com","pakistan");
			assertNotNull(validatedUser);
		}
	 
	 @Ignore
		@Test
		public void getUserByEmailId()
		{
			User user=userDao.get("rakesh@gmail.com");
			assertNotNull(user);
			System.out.println("Email ID :"+user.getEmailId());		
		}
		
	 @Ignore
		@Test
		public void updateUser()
		{
			User updateUser=userDao.get("rakesh@gmail.com");
			assertNotNull(updateUser);
			updateUser.setActive(false);
			assertEquals(true, userDao.update(updateUser));
		}
	 
	    @Ignore
		@Test
		public void testForGetAllUsers()
		{
			List<User> userList=userDao.list();
			assertNotNull(userList);
			assertEquals(3, userList.size());
		}
}
