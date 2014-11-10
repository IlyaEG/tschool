package ru.tsystems.ecare.services;

import java.util.List;

import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface CustomerService {

    List<Customer> getAllCustomers();

    List<Contract> getAllContracts();

    void lockCustomer(Customer toLock);

    void unlockCustomer(Customer toUnlock);

    Customer findByNumber(Integer number);

    void newCustomer(String name, String surname, String birtdate, String email,
            String password, String address, String passport);

    void newEmployee(Role role, Person person);

    Customer findByPassport(String passport);

    public boolean isLocked(Customer toLock);

}
