package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;

import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements
		RoleDAO {

	@Override
	public Role findByName(String name) {
		Query query = HibernateUtil.getSession()
				.getNamedQuery("findRoleByName").setString("roleName", name);
		return (Role) query.uniqueResult();
	}

}
