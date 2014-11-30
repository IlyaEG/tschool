package ru.tsystems.ecare.services.impl;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.exceptions.ECareException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Role;
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
    private TariffDAO tariffDAO;

    public TariffDAO getTariffDAO() {
        return tariffDAO;
    }

    @Autowired
    public void setTariffDAO(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

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
    public void newContract(Contract newContract, String employeeEmail) {
        Person employee = personDAO.findByEmail(employeeEmail);
        if (employee != null
                && employee.getRole().getName().equalsIgnoreCase("employee")) {
            contractDAO.add(newContract);
        } else {
            throw new ECareException("Only employees can add contracts!");
        }
    }

    @Override
    public Set<Integer> getAvailableNumbers() {
        Set<Integer> numbers = new HashSet<>();
        int maxNumber;
        try {
            maxNumber = contractDAO.getMaxumimumNumber();
        } catch (NullPointerException e) {
            maxNumber = 5550000;
        }
        for (int i = 1; i < 16; i++) {
            numbers.add(i + maxNumber);
        }
        return numbers;
    }

    @Override
    public Contract findByNumber(int number, String userEmail) {
        Person user = personDAO.findByEmail(userEmail);
        if (user != null) {
            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                Contract contract = contractDAO.findByNumber(number);
                return contract;
            } else if (user.getRole().getName().equalsIgnoreCase("customer")) {
                Contract contract = contractDAO.findByNumber(number);
                if (contract.getCustomer().getPerson().equals(user)) {
                    return contract;
                } else {
                    throw new ECareException("No contracts with this number!");
                }
            }
        } else {
            throw new ECareException("Access denied!");
        }
        return null;
    }

    @Override
    public Set<Contract> getAllContracts(String userEmail) {
        Person user = personDAO.findByEmail(userEmail);
        if (user != null) {
            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                return contractDAO.all();
            } else if (user.getRole().getName().equalsIgnoreCase("customer")) {
                Set<Contract> contracts = contractDAO.all();
                for (Contract contract : contracts) {
                    if (!contract.getCustomer().getPerson().equals(user)) {
                        contracts.remove(contract);
                    }
                }
                return contracts;
            }
        } else {
            throw new ECareException("Access denied!");
        }
        return null;
    }

    @Override
    public void save(Contract contract, String userEmail) {
        Person user = personDAO.findByEmail(userEmail);

        if (user != null) {

            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                contractDAO.update(contract);

            } else if (user.getRole().getName().equalsIgnoreCase("customer")) {

                if (contract.getCustomer().getPerson().equals(user)) {
                    Contract fromDAO = contractDAO.
                            findByNumber(contract.getNumber());
                    fromDAO.setTariff(tariffDAO.
                            findByName(contract.getTariff().getName()));
                    contractDAO.update(fromDAO);
                }
            }
        } else {
            throw new ECareException("Access denied!");
        }
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
    public Set<Contract> findAnyByNumber(int number, String userEmail) {
        Person user = personDAO.findByEmail(userEmail);
        if (user != null) {
            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                return contractDAO.findAnyByNumber(number);
            } else if (user.getRole().getName().equalsIgnoreCase("customer")) {
                Set<Contract> contracts = contractDAO.findAnyByNumber(number);
                for (Contract contract : contracts) {
                    if (!contract.getCustomer().getPerson().equals(user)) {
                        contracts.remove(contract);
                    }
                }
                return contracts;
            } else {
                throw new ECareException("No contracts with this number!");
            }
        } else {
            throw new ECareException("Access denied!");
        }
    }

    @Override
    public final void setOptions(final Contract contract,
            final Set<Option> activeOptions,
            final String userEmail) {
        Person user = personDAO.findByEmail(userEmail);
        if (user != null) {

            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                setOptions(activeOptions, contract);

            } else if (user.getRole().getName().equalsIgnoreCase("customer")) {

                if (contract.getCustomer().getPerson().equals(user)) {
                    setOptions(activeOptions, contract);
                }

            }
        } else {
            throw new ECareException("Access denied!");
        }
    }

    private void setOptions(final Set<Option> activeOptions,
            final Contract contract) throws ECareException {
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
        Contract fromDAO = contractDAO.
                findByNumber(contract.getNumber());
        fromDAO.setOptions(activeOptions);
        contractDAO.update(fromDAO);
    }

    @Override
    public void deleteContract(Contract contract, final String userEmail) {
        Person user = personDAO.findByEmail(userEmail);
        if (user != null) {

            if (user.getRole().getName().equalsIgnoreCase("employee")) {
                contractDAO.remove(contract);
            }
        } else {
            throw new ECareException("Access denied!");
        }
    }

}
