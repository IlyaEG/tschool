package ru.tsystems.ecare.persistence.dao;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.entities.Tariff;

/**
 * DAO of contract.
 */
public interface ContractDAO extends GenericDAO<Contract, Integer> {

    Integer getMaxumimumNumber();

    Contract findByNumber(int number);

    Set<Contract> findAnyByNumber(int number);

    Set<Option> getOptions(Contract contract);

    void addOption(Contract contract, Option option);

    void removeOption(Contract contract, Option option);

    Tariff getTariff(Contract contract);

    void setTariff(Contract contract, Tariff tariff);

    Role lockedBy(Contract contract);

    Boolean locked(Contract contract);

    void lock(Contract contract, Person locker);

    void unlock(Contract contract, Person locker);
}
