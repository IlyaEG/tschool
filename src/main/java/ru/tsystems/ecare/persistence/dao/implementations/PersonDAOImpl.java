package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.PersonDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import ru.tsystems.ecare.dto.PersonDTO;
import ru.tsystems.ecare.dto.RoleDTO;

import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public class PersonDAOImpl extends GenericDAOImpl<PersonDTO, Person> implements
        PersonDAO {

    @Override
    public PersonDTO validPerson(String login, String password) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.getNamedQuery("PersonByEmail&Password");
        query.setString("userEmail", login);
        query.setString("userPassword", password);
        Person person = (Person) query.uniqueResult();

        if (person != null && person.getEmail().equalsIgnoreCase(login) && person.getPassword().equals(password)) {
            PersonDTO personDTO = new PersonDTO();
            return personDTO.readEntity(person);
        }

        return null;
    }

    @Override
    public RoleDTO userRole(String login) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.getNamedQuery("PersonRole");
        query.setString("userEmail", login);
        Role role = (Role) query.uniqueResult();
        RoleDTO roleDTO = new RoleDTO();
        return roleDTO.readEntity(role);
    }

    @Override
    public PersonDTO findByEmail(String email) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.getNamedQuery("PersonByEmail");
        query.setString("userEmail", email);
        Person person = (Person) query.uniqueResult();
        PersonDTO personDTO = new PersonDTO();
        return personDTO.readEntity(person);
    }
}
