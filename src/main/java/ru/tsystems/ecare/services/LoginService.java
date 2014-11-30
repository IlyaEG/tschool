package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface LoginService {

    Person userValid(String login, String password);

    String getNameByEmail(String email);

    Role findRoleByName(String roleName);

    Customer findByEmail(String email);

    Person employee(String email);

}
