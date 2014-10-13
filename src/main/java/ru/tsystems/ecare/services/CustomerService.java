package ru.tsystems.ecare.services;

import java.util.List;

import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	List<Contract> getAllContracts();
	
	void lockCustomer(Customer toLock);
	
	void unlockCustomer(Customer toUnlock);
	
	Customer findByNumber(Integer number);
	
	

}
