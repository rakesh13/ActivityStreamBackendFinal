package com.stackroute.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.ActivityStreamBackend.dao.UserCircleDao;
import com.stackroute.ActivityStreamBackend.model.UserCircle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@EnableAspectJAutoProxy
public class UserCircleTest {

	@Autowired
	private UserCircle userCircle;

	@Autowired
	private UserCircleDao userCircleDao;
	
	@Ignore
	@Test
	public void addUserToCircleTest()
	{
		userCircle.setEmailId("ramesh@gmail.com");
		userCircle.setCircleName("errors");
		assertEquals(true, userCircleDao.addUserToCircle(userCircle.getEmailId(), userCircle.getCircleName()));
	}
	
	@Ignore
	@Test
	public void deleteUserFromCircleTest()
	{
		userCircle.setEmailId("ramesh@gmail.com");
		userCircle.setCircleName("errors");
		assertEquals(true, userCircleDao.deleteUserFromCircle(userCircle.getEmailId(), userCircle.getCircleName()));
	}
	
	@Ignore
	@Test
	public void getUsersOfCircleTest()
	{
		userCircle.setEmailId("rakesh@gmail.com");
		assertEquals(3, userCircleDao.getUsersOfCircle("general").size());
	}
	
}
