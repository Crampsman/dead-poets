package com.DeadPoets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.DeadPoets.DAO.RoleDao;
import com.DeadPoets.domain.Role;

@Component
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role getRole(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);
		
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		
	}

}
