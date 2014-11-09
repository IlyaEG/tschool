package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.entities.Contract;

@Repository("contractDAO")
public class ContractDAOImpl extends HibernateDAO<Contract, Integer>
        implements ContractDAO {

    @Override
    public Integer getMaxumimumNumber() {
        Query query = currentSession()
                .getNamedQuery("maximumNumber");
        return (Integer) query.uniqueResult();
    }

    @Override
    public Contract findByNumber(int number) {
        Query query = currentSession()
                .getNamedQuery("findContractByNumber")
                .setInteger("contractNumber", number);
        return (Contract) query.uniqueResult();
    }

}
