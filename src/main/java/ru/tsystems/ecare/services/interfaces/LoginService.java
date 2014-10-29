package ru.tsystems.ecare.services.interfaces;

import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.dto.PersonDTO;
import ru.tsystems.ecare.dto.RoleDTO;

public interface LoginService {

    PersonDTO userValid(String login, String password);

    RoleDTO userRole(String login);

    RoleDTO findRoleByName(String roleName);

    CustomerDTO findByEmail(String email);

    public void closeSession();

}
