package ru.tsystems.ecare.services.interfaces;

import java.util.List;
import ru.tsystems.ecare.dto.ContractDTO;

public interface ContractService {

    void newContract(ContractDTO newContract);

    void setNumber(Integer number);

    public List<Integer> getAvailableNumbers();

    public ContractDTO findByNumber(int number);

    public List<ContractDTO> getAllContracts();

    public void save(ContractDTO contract);

    public void lockContract(ContractDTO contract);

}
