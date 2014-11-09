package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.entities.Tariff;

@Repository("tariffDAO")
public class TariffDAOImpl extends HibernateDAO<Tariff, Integer>
        implements TariffDAO {

    @Override
    public Tariff findByName(String name) {
        Query query = currentSession()
                .getNamedQuery("findTariffByName").setString("tariffName", name);
        return (Tariff) query.uniqueResult();
    }

}
