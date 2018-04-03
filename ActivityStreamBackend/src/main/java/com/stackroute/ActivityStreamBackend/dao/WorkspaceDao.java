package com.stackroute.ActivityStreamBackend.dao;

import java.util.List;

import com.stackroute.ActivityStreamBackend.model.Workspace;

public interface WorkspaceDao {

	boolean createWorkspace(Workspace workspace);
	List<Workspace> getWorkspaceByAdminEmailId(String emailId);
}
