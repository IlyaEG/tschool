package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.RoleDTO;
import ru.tsystems.ecare.persistence.entities.Role;

public interface RoleDAO extends GenericDAO<RoleDTO, Role> {

    RoleDTO findByName(String name);

}
