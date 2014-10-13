package ru.tsystems.ecare.services;

import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractService {

	Contract showContract();
	
	boolean lockNumber();
	
	boolean unlockNumber();	
	
}
