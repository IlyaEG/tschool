package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.TariffDAO;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.TariffDTO;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class TariffDAOImpl extends GenericDAOImpl<TariffDTO, Tariff>
        implements TariffDAO {

    @Override
    public TariffDTO findByName(String name) {
        Query query = HibernateUtil.getSession()
                .getNamedQuery("findTariffByName").setString("tariffName", name);
        Tariff tariff = (Tariff) query.uniqueResult();
        TariffDTO tariffDTO = new TariffDTO();
        return tariffDTO.readEntity(tariff);
    }

}
