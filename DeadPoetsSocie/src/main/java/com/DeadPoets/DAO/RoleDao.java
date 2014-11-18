package com.DeadPoets.DAO;

import java.util.List;

import com.DeadPoets.domain.Role;

public interface RoleDao {

	public Role getRole(Long id);
	
	public void updateRole(Role role);
	
	public void addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public void deleteRole(Role role);
}
