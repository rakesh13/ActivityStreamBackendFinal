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

import com.stackroute.ActivityStreamBackend.dao.CircleDao;
import com.stackroute.ActivityStreamBackend.model.Circle;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@EnableAspectJAutoProxy
public class CircleTest {

	@Autowired
	private CircleDao circleDao;
	@Autowired
	private Circle circle;

	@Ignore
	@Test
	public void addToCircleTest() {
		circle.setCircleName("errors");
		circle.setCreatedBy("rakesh@gmail.con");
		circle.setStatus(true);
		assertEquals(true, circleDao.addCircle(circle));
	}

	@Ignore
	@Test
	public void getAllCirclesTest() {
		List<Circle> circles = circleDao.getAllCircles();
		assertEquals(5, circles.size());
	}

	@Ignore
	@Test
	public void deleteCircleTest() {
		circle = circleDao.getCircleByName("random");
		assertEquals(true, circleDao.deleteCircle(circle.getCircleName(), circle.getCreatedBy()));
	}

}
