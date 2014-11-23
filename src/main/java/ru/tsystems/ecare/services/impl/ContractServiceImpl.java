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
import ru.tsystems.ecare.persistence.dao.RoleDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Role;
import ru.tsystems.ecare.services.ContractService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    // dependencies
    private SessionFactory sessionFactory;
    private ContractDAO contractDAO;
    private RoleDAO roleDAO;

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
    public void lockNumber() {

		// dao

        // dao.lockNumber
        // throw Exception
        //TODO Auto-generated method stub
        throw new ECareException("not implemented yet!");
    }

    @Override
    public void unlockNumber() {
        // TODO Auto-generated method stub
        throw new ECareException("not implemented yet!");
    }

    @Override
    public void newContract(Contract newContract) {
        contractDAO.add(newContract);
    }

    @Override
    public void setNumber(Integer number) {
        // TODO Auto-generated method stub
        throw new ECareException("not implemented yet!");
    }

    @Override
    public Set<Integer> getAvailableNumbers() {
        Set<Integer> numbers = new HashSet<>();
        int maxNumber;
        try {
            maxNumber = contractDAO.getMaxumimumNumber();
        }
        catch (NullPointerException e) {
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
        Set<Contract> contract = contractDAO.all();
        return contract;
    }

    @Override
    public void save(Contract contract) {
        contractDAO.add(contract);
    }

    @Override
    public void lockNumber(int number, String newlockerRole) {
        Contract contract = contractDAO.findByNumber(number);
        Role newLocker = roleDAO.findByName(newlockerRole);
        if (newLocker != null) {
            //todo
        }
        contract.setLockedBy(null);
    }

}
