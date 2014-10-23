package ru.tsystems.ecare.services;

import java.util.ArrayList;
import java.util.List;
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
		return;
	}

	public void unlockNumber() {
		// TODO Auto-generated method stub
		return;
	}

	public Contract showContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract newContract(Contract newContract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumber(Integer number) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public List<Integer> getAvailableNumbers() {
		HibernateUtil.beginTransaction();
		List<Integer> numbers = new ArrayList<>();
		Integer maxNumber = contractDAO.getMaxumimumNumber();
		for (int i = 0; i < 5; i++) {
			numbers.add(i + maxNumber);
		}
		HibernateUtil.commitTransaction();
		return numbers;
	}

}
