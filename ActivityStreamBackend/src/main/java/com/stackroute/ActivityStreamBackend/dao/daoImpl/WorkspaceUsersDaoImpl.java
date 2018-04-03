package com.stackroute.ActivityStreamBackend.dao.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.ActivityStreamBackend.dao.WorkspaceUsersDao;
import com.stackroute.ActivityStreamBackend.model.Workspace;
import com.stackroute.ActivityStreamBackend.model.WorkspaceUsers;

@Repository(value = "workspaceUsersDao")
@Component
@Transactional
public class WorkspaceUsersDaoImpl implements WorkspaceUsersDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean sendInvitation(String companyName, String userEmailId) {
		try {
			WorkspaceUsers workspaceUsers = new WorkspaceUsers();
			workspaceUsers.setCompanyName(companyName);
			workspaceUsers.setUserEmailId(userEmailId);
			workspaceUsers.setStatus('N');
			sessionFactory.getCurrentSession().save(workspaceUsers);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean acceptInvitation(String companyName, String userEmailId) {
		try {
			WorkspaceUsers workspaceUsers = getWorkspaceByCompanyNameUserID(companyName, userEmailId);
			workspaceUsers.setStatus('A');
			sessionFactory.getCurrentSession().update(workspaceUsers);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	private WorkspaceUsers getWorkspaceByCompanyNameUserID(String companyName,String userEmailId)
	{
		try
		{
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(WorkspaceUsers.class);
			criteria.add(Restrictions.eq("userEmailId", userEmailId));
			criteria.add(Restrictions.eq("companyName", companyName));
			WorkspaceUsers workspaceUsers=(WorkspaceUsers)criteria.uniqueResult();
			return workspaceUsers;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	@Override
	public boolean rejectInvitation(String companyName, String userEmailId) {
		try {
			WorkspaceUsers workspaceUsers = getWorkspaceByCompanyNameUserID(companyName, userEmailId);
			workspaceUsers.setStatus('R');
			sessionFactory.getCurrentSession().update(workspaceUsers);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeUserFromWorkspace(String companyName, String userEmailId) {
		try {
			WorkspaceUsers workspaceUsers = getWorkspaceByCompanyNameUserID(companyName, userEmailId);
			sessionFactory.getCurrentSession().delete(workspaceUsers);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
