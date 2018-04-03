package com.stackroute.ActivityStreamBackend.dao;

public interface WorkspaceUsersDao {

	boolean sendInvitation(String companyName,String userEmailId);
	boolean acceptInvitation(String companyName,String userEmailId);
	boolean rejectInvitation(String companyName,String userEmailId);
	boolean removeUserFromWorkspace(String companyName,String userEmailId);
}
