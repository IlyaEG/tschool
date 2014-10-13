package ru.tsystems.ecare.persistence.dao;


import org.hibernate.Query;

import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class RoleDAOImpl extends GenericDAOImpl<Role, Integer> implements RoleDAO {

	@Override
	public Role findByName(String name) {
		Role role = null;
        String sql = "SELECT r FROM Role r WHERE r.Role = :name";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("name", name);
        role = findOne(query);
        return role;
	}
	
}
