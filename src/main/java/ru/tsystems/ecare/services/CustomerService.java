package ru.tsystems.ecare.services;

import java.util.Set;

import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;

public interface CustomerService {

    Set<Customer> getAllCustomers();

    Set<Contract> getAllContracts(Customer customer);

    void lockCustomer(Customer toLock);

    void unlockCustomer(Customer toUnlock);

    Customer findByNumber(Integer number);

    void saveCustomer(String name, String surname, String birtdate, String email,
            String password, String address, String passport);

    void newEmployee(Role role, Person person);

    Customer findByPassport(String passport);

    boolean isLocked(Customer toLock);

    void deleteCustomer(Customer c);

}
