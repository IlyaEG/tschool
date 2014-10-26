package ru.tsystems.ecare.services;

import java.util.ArrayList;
import java.util.List;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.ContractDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class ContractServiceImpl implements ContractService {

	private static ContractDAO contractDAO = new ContractDAOImpl();

	public void lockNumber() {
		// dao

		// dao.lockNumber

		// throw Exception


		// TODO Auto-generated method stub
		throw new ECareException("not implemented yet!");
	}

	public void unlockNumber() {
		// TODO Auto-generated method stub
		throw new ECareException("not implemented yet!");
	}

	public Contract showContract() {
		// TODO Auto-generated method stub
		throw new ECareException("not implemented yet!");
	}

	@Override
	public void newContract(Contract newContract) {
		HibernateUtil.beginTransaction();
		contractDAO.save(newContract);
		HibernateUtil.commitTransaction();
	}

	@Override
	public void setNumber(Integer number) {
		// TODO Auto-generated method stub
		throw new ECareException("not implemented yet!");
	}

	@Override
	public List<Integer> getAvailableNumbers() {
		HibernateUtil.beginTransaction();
		List<Integer> numbers = new ArrayList<>();
		int maxNumber;
		try {
			maxNumber = contractDAO.getMaxumimumNumber();
		} catch (NullPointerException e) {
			maxNumber = 1;
		}
		for (int i = 0; i < 15; i++) {
			numbers.add(i + maxNumber);
		}
		HibernateUtil.commitTransaction();
		return numbers;
	}

}
