package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements
		RoleDAO {

	@Override
	public Role findByName(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findRoleByName");
		query.setString("roleName", "employee");
		Role r = (Role)query.uniqueResult();
		return r; 
	}

}
