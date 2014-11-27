package ru.tsystems.ecare.services;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractService {

    void unlockNumber(int number, String userEmail);

    void newContract(Contract newContract);

    Set<Integer> getAvailableNumbers();

    Contract findByNumber(int number);

    Set<Contract> findAnyByNumber(int number);

    Set<Contract> getAllContracts();

    void save(Contract contract);

    void lockNumber(int number, String userEmail);

}
