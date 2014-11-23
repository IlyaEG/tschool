package ru.tsystems.ecare.services.impl;

import java.util.Set;
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
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Set<Tariff> getAvailableTariffs() {
        Set<Tariff> availableTariffs = tariffDAO.all();
        return availableTariffs;
    }

    @Override
    public void changeTariff(Contract customerContract, Tariff newTariff) {
        customerContract.setTariff(newTariff);
        contractDAO.update(customerContract);
    }

    @Override
    public Set<Option> getAvailableOptions() {
        Set<Option> options = optionDAO.all();
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
