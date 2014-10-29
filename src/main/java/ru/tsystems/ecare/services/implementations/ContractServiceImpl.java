package ru.tsystems.ecare.services.implementations;

import ru.tsystems.ecare.services.interfaces.ContractService;
import java.util.ArrayList;
import java.util.List;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.persistence.dao.interfaces.ContractDAO;
import ru.tsystems.ecare.persistence.dao.implementations.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.RoleDAO;
import ru.tsystems.ecare.persistence.dao.implementations.RoleDAOImpl;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class ContractServiceImpl implements ContractService {

    private static final ContractDAO contractDAO = new ContractDAOImpl();
    private static final RoleDAO roleDAO = new RoleDAOImpl();

// todo example
//    public void lockNumber() {
//		// dao
//
//		// dao.lockNumber
//		// throw Exception
//        // TODO Auto-generated method stub
//        throw new ECareException("not implemented yet!");
//    }

    @Override
    public final void newContract(ContractDTO newContract) {
        HibernateUtil.beginTransaction();
        contractDAO.save(newContract);
        HibernateUtil.commitTransaction();
    }

    @Override
    public final void setNumber(Integer number) {
        // TODO Auto-generated method stub
        throw new ECareException("not implemented yet!");
    }

    @Override
    public final List<Integer> getAvailableNumbers() {
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
    public final ContractDTO findByNumber(int number) {
        HibernateUtil.beginTransaction();
        ContractDTO contract = contractDAO.findByNumber(number);
        HibernateUtil.commitTransaction();
        return contract;
    }

    @Override
    public final List<ContractDTO> getAllContracts() {
        HibernateUtil.beginTransaction();
        List<ContractDTO> contract = contractDAO.findAll(ContractDTO.class);
        HibernateUtil.commitTransaction();
        return contract;
    }

    @Override
    public final void save(ContractDTO contract) {
        HibernateUtil.beginTransaction();
        contractDAO.save(contract);
        HibernateUtil.commitTransaction();
    }

    @Override
    public final void lockContract(ContractDTO contract){
        HibernateUtil.beginTransaction();
//        todo
//        if (newLocker != null) {
//            todo
//        }
//        todo
//        contract.setLockedBy(null);
        HibernateUtil.commitTransaction();
    }

}
