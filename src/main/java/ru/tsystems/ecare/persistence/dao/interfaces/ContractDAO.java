package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.persistence.entities.Contract;

public interface ContractDAO extends GenericDAO<ContractDTO, Contract> {

    Integer getMaxumimumNumber();

    ContractDTO findByNumber(int number);

}
