package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Role;

public interface RoleDAO extends GenericDAO<Role, Integer> {
	
	Role findByName(String name);

}
