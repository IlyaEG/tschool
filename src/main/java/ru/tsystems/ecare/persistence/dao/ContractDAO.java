package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractDAO extends GenericDAO<Contract, Integer> {

	Integer getMaxumimumNumber();
	
	Contract findByNumber(int number);

}
