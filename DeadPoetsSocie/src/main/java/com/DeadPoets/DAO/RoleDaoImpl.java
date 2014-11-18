package com.DeadPoets.DAO;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.DeadPoets.domain.Role;
import com.DeadPoets.util.HibernateUtil;

@Component
public class RoleDaoImpl implements RoleDao {

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
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();
		
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
