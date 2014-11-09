package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Contract;

/**
 * DAO of contract.
 */

public interface ContractDAO extends GenericDAO<Contract, Integer> {

	Integer getMaxumimumNumber();
	
	Contract findByNumber(int number);

}
