package com.DeadPoets.services;

import java.util.List;

import com.DeadPoets.domain.Role;

public interface RoleService {

	public Role getRole(Long id);
	
	public void updateRole(Role role);
	
	public void addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public void deleteRole(Role role);
}
