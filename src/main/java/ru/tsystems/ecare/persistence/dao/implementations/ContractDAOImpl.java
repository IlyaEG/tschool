package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.ContractDAO;
import java.util.List;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.persistence.entities.Contract;

public class ContractDAOImpl extends GenericDAOImpl<ContractDTO, Contract> implements
        ContractDAO {

    @Override
    public Integer getMaxumimumNumber() {
        Query query = this.getSession()
                .getNamedQuery("maximumNumber");
        return (Integer) query.uniqueResult();
    }

    @Override
    public ContractDTO findByNumber(int number) {
        Query query = this.getSession()
                .getNamedQuery("findContractByNumber").setInteger("contractNumber", number);
        Contract contract = (Contract) query.uniqueResult();
        ContractDTO contractDTO = new ContractDTO();
        return contractDTO.readEntity(contract);
    }

}
