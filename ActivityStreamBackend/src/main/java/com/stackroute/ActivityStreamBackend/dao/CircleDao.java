package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.Circle;



public interface CircleDao {

	boolean addCircle(Circle circle);
	boolean deleteCircle(String emailId,String circleName);
	List<Circle> getAllCircles();
	List<Circle> getCircleByUser(String emailId);
	Circle getCircleByName(String circleName);
}

