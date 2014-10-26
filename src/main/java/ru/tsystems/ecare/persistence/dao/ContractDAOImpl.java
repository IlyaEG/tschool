package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;
import ru.tsystems.ecare.persistence.entities.Contract;

public class ContractDAOImpl extends GenericDAOImpl<Contract, Integer> implements
		ContractDAO {

	@Override
	public Integer getMaxumimumNumber() {
		Query query = this.getSession()
				.getNamedQuery("maximumNumber");
		return (Integer)query.uniqueResult();
	}

	@Override
	public Contract findByNumber(int number) {
		Query query = this.getSession()
				.getNamedQuery("findContractByNumber").setInteger("contractNumber", number);
		return (Contract)query.uniqueResult();
	}

}
