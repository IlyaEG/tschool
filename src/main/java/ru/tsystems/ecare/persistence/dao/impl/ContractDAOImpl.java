package ru.tsystems.ecare.persistence.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.persistence.entities.Tariff;

/**
 * Implementation of contract DAO.
 *
 */
@Repository("contractDAO")
public class ContractDAOImpl extends HibernateDAO<Contract, Integer>
        implements ContractDAO {

    private PersonDAO personDAO;

    @Autowired
    public final void setPersonDao(final PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public final PersonDAO getPersonDao() {
        return personDAO;
    }

    @Override
    public final Integer getMaxumimumNumber() {
        Query query = currentSession()
                .getNamedQuery("maximumNumber");
        return (Integer) query.uniqueResult();
    }

    @Override
    public final Contract findByNumber(final int number) {
        Query query = currentSession()
                .getNamedQuery("findContractByNumber")
                .setInteger("contractNumber", number);
        return (Contract) query.uniqueResult();
    }

    @Override
    public final Set<Option> getOptions(final Contract contract) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract with number "
                    + contract.getNumber() + " not found!");
        }
        return storedContract.getOptions();
    }

    @Override
    public final void addOption(final Contract contract, final Option option) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract with number "
                    + contract.getNumber() + " not found!");
        }
        storedContract.getOptions().add(option);
        update(storedContract);
    }

    @Override
    public final void removeOption(final Contract contract,
            final Option option) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract with number "
                    + contract.getNumber() + " not found!");
        }
        storedContract.getOptions().remove(option);
        update(storedContract);
    }

    @Override
    public final Tariff getTariff(final Contract contract) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract with number "
                    + contract.getNumber() + " not found!");
        }
        return storedContract.getTariff();
    }

    @Override
    public final void setTariff(final Contract contract, final Tariff tariff) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract with number "
                    + contract.getNumber() + " not found!");
        }
        storedContract.setTariff(tariff);
    }

    @Override
    public final Role lockedBy(final Contract contract) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " not foud!");
        }
        return storedContract.getLockedBy();
    }

    @Override
    public final Boolean locked(final Contract contract) {
        Contract storedContract = find(contract.getNumber());
        if (storedContract == null) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " not foud!");
        }
        return storedContract.getLockedBy() != null;
    }

    @Override
    public final void lock(final Contract contract, final Person locker) {
        Contract storedContract = find(contract.getNumber());
        //check if conract exists
        if (storedContract == null) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " not foud!");
        }
        //check if contract is already locked
        if (locked(storedContract)) {
            throw new ECareException("Contract " + storedContract.getNumber()
                    + " is already locked by "
                    + storedContract.getLockedBy().getName());
        }
        Person storedPerson = personDAO.find(locker.getId());
        //check if locker person exists
        if (storedPerson == null) {
            throw new ECareException("Person " + contract.getNumber()
                    + " not foud!");
        }
        //check locker Role
        //if locker role is Employee
        if (storedPerson.getRole().getName().equalsIgnoreCase("employee")) {
            //just lock
            storedContract.setLockedBy(storedPerson.getRole());
            update(storedContract);
            //if locker role is Customer
        } else if (storedPerson.getRole().getName()
                .equalsIgnoreCase("customer")) {
            //check if contract belongs to customer
            if (storedContract.getCustomer().getPerson().equals(storedPerson)) {
                //lock
                storedContract.setLockedBy(storedPerson.getRole());
                update(storedContract);
            } else {
                throw new ECareException("Customer can not lock contract"
                        + " belonging to another customer!");
            }
        }
    }

    @Override
    public final void unlock(final Contract contract, final Person unlocker) {
        Contract storedContract = find(contract.getNumber());
        //check if conract exists
        if (storedContract == null) {
            throw new ECareException("Contract " + contract.getNumber()
                    + " not foud!");
        }
        //check if contract is already unlocked
        if (!locked(storedContract)) {
            throw new ECareException("Contract " + storedContract.getNumber()
                    + " is already unlocked!");
        }
        Person storedPerson = personDAO.find(unlocker.getId());
        //check if unlocker person exists
        if (storedPerson == null) {
            throw new ECareException("Person " + contract.getNumber()
                    + " not foud!");
        }
        //check unlocker Role
        //if unlocker role is Employee
        if (storedPerson.getRole().getName().equalsIgnoreCase("employee")) {
            //unlock
            storedContract.setLockedBy(null);
            update(storedContract);
            //if locker role is Customer
        } else if (storedPerson.getRole().getName()
                .equalsIgnoreCase("customer")) {
            //check if contract belongs to customer
            if (storedContract.getCustomer().getPerson().equals(storedPerson)) {
                //check if locker is customer
                if (storedContract.getLockedBy().getName().
                        equalsIgnoreCase("customer")) {
                    //lock
                    storedContract.setLockedBy(storedPerson.getRole());
                    update(storedContract);
                } else {
                    throw new ECareException("Customer can not unlock contract"
                            + " locked by employee!");
                }
            } else {
                throw new ECareException("Customer can not unlock contract"
                        + " belonging to another customer!");
            }
        }
    }

    @Override
    public final Set<Contract> findAnyByNumber(final int number) {
        Query query = currentSession()
                .getNamedQuery("findAnyContractByNumber")
                .setString("contractNumber", "%" + number + "%");
        List list = query.list();
        Set<Contract> contracts = new HashSet<>();
        for (Object o : list) {
            contracts.add((Contract) o);
        }
        return contracts;
    }
}
