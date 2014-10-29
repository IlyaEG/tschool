package ru.tsystems.ecare.services.interfaces;

import java.util.List;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.dto.CustomerDTO;
import ru.tsystems.ecare.dto.EmployeeDTO;


public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    List<ContractDTO> getAllContracts();

    void lockCustomer(CustomerDTO toLock);

    void unlockCustomer(CustomerDTO toUnlock);

    CustomerDTO findByNumber(Integer number);

    void newCustomer(CustomerDTO newCustomer);

    void newEmployee(EmployeeDTO newEmployee);

    CustomerDTO findByPassport(String passport);

    boolean isLocked(CustomerDTO toLock);

}
