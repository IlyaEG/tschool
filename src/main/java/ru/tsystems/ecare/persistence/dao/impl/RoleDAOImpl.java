package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.RoleDAO;

import ru.tsystems.ecare.persistence.entities.Role;

@Repository("optionDAO")
public class RoleDAOImpl extends HibernateDAO<Role, Integer>
        implements RoleDAO {

    @Override
    public Role findByName(String name) {
        Query query = currentSession().getNamedQuery("findRoleByName")
                .setString("roleName", name);
        return (Role) query.uniqueResult();
    }

}
