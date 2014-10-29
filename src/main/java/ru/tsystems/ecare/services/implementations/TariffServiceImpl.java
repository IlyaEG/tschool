package ru.tsystems.ecare.services.implementations;

import ru.tsystems.ecare.services.interfaces.TariffService;
import java.util.List;
import org.hibernate.HibernateException;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.dto.OptionDTO;
import ru.tsystems.ecare.dto.TariffDTO;
import ru.tsystems.ecare.persistence.dao.interfaces.ContractDAO;
import ru.tsystems.ecare.persistence.dao.implementations.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.OptionDAO;
import ru.tsystems.ecare.persistence.dao.implementations.OptionDAOImpl;
import ru.tsystems.ecare.persistence.dao.interfaces.TariffDAO;
import ru.tsystems.ecare.persistence.dao.implementations.TariffDAOImpl;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class TariffServiceImpl implements TariffService {

    private static final TariffDAO tariffDAO = new TariffDAOImpl();
    private static final ContractDAO contractDAO = new ContractDAOImpl();
    private static final OptionDAO optionDAO = new OptionDAOImpl();

    public TariffServiceImpl() {
    }

    @Override
    public List<TariffDTO> getAvailableTariffs() {
        HibernateUtil.beginTransaction();
        List<TariffDTO> availableTariffs = tariffDAO.findAll(TariffDTO.class);
        HibernateUtil.commitTransaction();
        return availableTariffs;
    }

    @Override
    public void changeTariff(ContractDTO customerContract) {
        HibernateUtil.beginTransaction();
        contractDAO.save(customerContract);
        HibernateUtil.commitTransaction();
    }

    @Override
    public List<OptionDTO> getAvailableOptions() {
        HibernateUtil.beginTransaction();
        List<OptionDTO> options = optionDAO.findAll(OptionDTO.class);
        HibernateUtil.commitTransaction();
        return options;
    }

    @Override
    public void createTariff(TariffDTO newTariff) {
        try {
            HibernateUtil.beginTransaction();
            tariffDAO.save(newTariff);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw ex;
        }
    }

    @Override
    public void deleteTariff(TariffDTO oldTariff) {
        try {
            HibernateUtil.beginTransaction();
            tariffDAO.delete(oldTariff);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw ex;
        }

    }

    @Override
    public TariffDTO findById(int id) {
        HibernateUtil.beginTransaction();
        TariffDTO tariff = tariffDAO.findByID(TariffDTO.class, id);
        HibernateUtil.commitTransaction();
        return tariff;
    }

    @Override
    public void updateTariff(TariffDTO tariff) {
        HibernateUtil.beginTransaction();
        tariffDAO.save(tariff);
        HibernateUtil.commitTransaction();
    }

}
