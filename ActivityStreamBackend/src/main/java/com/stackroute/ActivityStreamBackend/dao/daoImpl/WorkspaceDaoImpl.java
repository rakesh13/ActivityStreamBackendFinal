package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.UserCircleDao;
import com.stackroute.ActivityStreamBackend.dao.WorkspaceDao;
import com.stackroute.ActivityStreamBackend.model.Workspace;

@Repository(value="workspaceDao")
@Component
@Transactional
public class WorkspaceDaoImpl implements WorkspaceDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean createWorkspace(Workspace workspace) {
		try
		{
			sessionFactory.getCurrentSession().save(workspace);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public List<Workspace> getWorkspaceByAdminEmailId(String emailId) {
		try
		{
			String hql="from Workspace where adminEmailId= '" + emailId +"'";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return null;
	}

	

}
