package ru.tsystems.ecare.services;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;

public interface ContractService {

    void unlockNumber(int number, String lockerEmail);

    void newContract(Contract newContract, String employeeEmail);

    Set<Integer> getAvailableNumbers();

    Contract findByNumber(int number, String userEmail);

    Set<Contract> findAnyByNumber(int number, String userEmail);

    Set<Contract> getAllContracts(String userEmail);

    void save(Contract contract, String userEmail);

    void lockNumber(int number, String userEmail);

    void setOptions(Contract contract, Set<Option> activeOptions,
            String userEmail);

    void deleteContract(Contract c, String userEmail);

}
