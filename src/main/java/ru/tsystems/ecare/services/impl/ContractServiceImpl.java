package ru.tsystems.ecare.services.impl;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.services.ContractService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    // dependencies
    private SessionFactory sessionFactory;
    private ContractDAO contractDAO;
    private RoleDAO roleDAO;
    private PersonDAO personDAO;
    private OptionDAO optionDAO;

    public OptionDAO getOptionDAO() {
        return optionDAO;
    }

    @Autowired
    public void setOptionDAO(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public ContractDAO getContractDAO() {
        return contractDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void unlockNumber(int number, String userEmail) {
        Contract contract = contractDAO.findByNumber(number);
        Person unLocker = personDAO.findByEmail(userEmail);
        if (unLocker != null) {
            contractDAO.unlock(contract, unLocker);
        }
    }

    @Override
    public void newContract(Contract newContract) {
        contractDAO.add(newContract);
    }

    @Override
    public Set<Integer> getAvailableNumbers() {
        Set<Integer> numbers = new HashSet<>();
        int maxNumber;
        try {
            maxNumber = contractDAO.getMaxumimumNumber();
        } catch (NullPointerException e) {
            maxNumber = 1;
        }
        for (int i = 0; i < 15; i++) {
            numbers.add(i + maxNumber);
        }
        return numbers;
    }

    @Override
    public Contract findByNumber(int number) {
        Contract contract = contractDAO.findByNumber(number);
        return contract;
    }

    @Override
    public Set<Contract> getAllContracts() {
        return contractDAO.all();
    }

    @Override
    public void save(Contract contract) {
        contractDAO.update(contract);
    }

    @Override
    public void lockNumber(int number, String userEmail) {
        Contract contract = contractDAO.findByNumber(number);
        Person newLocker = personDAO.findByEmail(userEmail);
        if (newLocker != null) {
            contractDAO.lock(contract, newLocker);
        }
    }

    @Override
    public Set<Contract> findAnyByNumber(int number) {
        return contractDAO.findAnyByNumber(number);
    }

    @Override
    public final void setOptions(final Contract contract,
            final Set<Option> activeOptions) {
        //check incompatibility and relatedness
        for (Option ao : activeOptions) {
            //check if options are incompatible
            for (Option io : ao.getOptionsForIncompId2()) {
                if (activeOptions.contains(io)) {
                    throw new ECareException("Options " + ao.getName() + " "
                            + io.getName() + " are incompatible!");
                }
            }
            //check if missed related options
            for (Option ro : ao.getOptionsForRelId2()) {
                if (!activeOptions.contains(ro)) {
                    throw new ECareException("Options " + ao.getName() + " and "
                                + ro.getName() + " are related!");
                }
            }
        }
        //save
        contract.setOptions(activeOptions);
        contractDAO.update(contract);
    }

    @Override
    public void deleteContract(Contract c) {
        contractDAO.remove(c);
    }

}
