package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

@Repository("personDAO")
public class PersonDAOImpl extends HibernateDAO<Person, Integer>
        implements PersonDAO {

    @Override
    public final Person validPerson(final String login, final String password) {
        Session hibernateSession = currentSession();
        Query query = hibernateSession.getNamedQuery("PersonByEmail&Password");
        query.setString("userEmail", login);
        query.setString("userPassword", password);
        Person person = (Person) query.uniqueResult();

        if (person != null && person.getEmail().equalsIgnoreCase(login) && person.getPassword().equals(password)) {
            return person;
        }

        return null;
    }

    @Override
    public final Role personRole(final Person person) {
        Session hibernateSession = currentSession();
        Query query = hibernateSession.getNamedQuery("PersonRole");
        query.setString("userEmail", person.getEmail());
        return (Role) query.uniqueResult();
    }

    @Override
    public final Person findByEmail(final String email) {
        Session hibernateSession = currentSession();
        Query query = hibernateSession.getNamedQuery("PersonByEmail");
        query.setString("userEmail", email);
        return (Person) query.uniqueResult();
    }
}
