package ru.tsystems.ecare.services;

import java.util.ArrayList;
import java.util.List;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class ContractServiceImpl implements ContractService {

	private static final ContractDAO contractDAO = new ContractDAOImpl();
	private static final RoleDAO roleDAO = new RoleDAOImpl();

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

	@Override
	public Contract findByNumber(int number) {
		HibernateUtil.beginTransaction();
		Contract contract = contractDAO.findByNumber(number);
		HibernateUtil.commitTransaction();
		return contract;
	}

	@Override
	public List<Contract> getAllContracts() {
		HibernateUtil.beginTransaction();
		List<Contract> contract = contractDAO.findAll(Contract.class);
		HibernateUtil.commitTransaction();
		return contract;
	}

	@Override
	public void save(Contract contract) {
		HibernateUtil.beginTransaction();
		contractDAO.save(contract);
		HibernateUtil.commitTransaction();
	}

	@Override
	public void lockNumber(int number, String newlockerRole) {
		HibernateUtil.beginTransaction();
		Contract contract = contractDAO.findByNumber(number);
		Role newLocker = roleDAO.findByName(newlockerRole);
		if (newLocker != null) {
			//todo
		}
		contract.setLockedBy(null);
		HibernateUtil.commitTransaction();
	}

}
