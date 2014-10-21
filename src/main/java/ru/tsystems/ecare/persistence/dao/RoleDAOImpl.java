package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;

import ru.tsystems.ecare.persistence.entities.Role;

public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements
		RoleDAO {

	@Override
	public Role findByName(String name) {
		Query query = this.getSession()
				.getNamedQuery("findRoleByName").setString("roleName", name);
		return (Role) query.uniqueResult();
	}

}
