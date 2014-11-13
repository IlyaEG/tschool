package ru.tsystems.ecare.services.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("tariffService")
public class TariffServiceImpl implements TariffService {

    // dependencies
    private SessionFactory sessionFactory;
    private TariffDAO tariffDAO;
    private ContractDAO contractDAO;
    private OptionDAO optionDAO;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setTariffDAO(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    @Autowired
    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Autowired
    public void setOptionDAO(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public TariffDAO getTariffDAO() {
        return tariffDAO;
    }

    public ContractDAO getContractDAO() {
        return contractDAO;
    }

    public OptionDAO getOptionDAO() {
        return optionDAO;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Tariff> getAvailableTariffs() {
        List<Tariff> availableTariffs = tariffDAO.list();
        return availableTariffs;
    }

    @Override
    public void changeTariff(Contract customerContract, Tariff newTariff) {
        customerContract.setTariff(newTariff);
        contractDAO.update(customerContract);
    }

    @Override
    public List<Option> getAvailableOptions() {
        List<Option> options = optionDAO.list();
        return options;
    }

    @Override
    public void createTariff(Tariff newTariff) {
        tariffDAO.add(newTariff);
    }

    @Override
    public void deleteTariff(Tariff oldTariff) {
        tariffDAO.remove(oldTariff);
    }

    @Override
    public Tariff findById(int id) {
        Tariff tariff = tariffDAO.find(id);
        return tariff;
    }

    @Override
    public void updateTariff(Tariff tariff) {
        tariffDAO.update(tariff);
    }

}
