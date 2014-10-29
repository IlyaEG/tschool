package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.RoleDAO;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.RoleDTO;

import ru.tsystems.ecare.persistence.entities.Role;

public class RoleDAOImpl extends GenericDAOImpl<RoleDTO, Role> implements
        RoleDAO {

    @Override
    public RoleDTO findByName(String name) {
        Query query = this.getSession()
                .getNamedQuery("findRoleByName").setString("roleName", name);
        Role role = (Role) query.uniqueResult();
        RoleDTO roleDTO = new RoleDTO();
        return roleDTO.readEntity(role);
    }

}
