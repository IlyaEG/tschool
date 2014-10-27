package ru.tsystems.ecare.services;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractService {

	void lockNumber();

	void unlockNumber();

	void newContract(Contract newContract);

	void setNumber(Integer number);

	public List<Integer> getAvailableNumbers();

	public Contract findByNumber(int number);

	public List<Contract> getAllContracts();

	public void save(Contract contract);

	public void lockNumber(int number, String lockedByRole);

}
