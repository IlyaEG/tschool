package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractService {

	Contract showContract();
	
	void lockNumber();
	
	void unlockNumber();
	
	Contract newContract(Contract newContract);
	
	void setNumber(Integer number);
	
}
