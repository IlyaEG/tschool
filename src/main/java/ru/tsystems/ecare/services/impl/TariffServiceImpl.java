package ru.tsystems.ecare.services.impl;

import java.util.Set;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.exceptions.ECareException;
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

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TariffDAO getTariffDAO() {
        return tariffDAO;
    }

    @Autowired
    public void setTariffDAO(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    public ContractDAO getContractDAO() {
        return contractDAO;
    }

    @Autowired
    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public OptionDAO getOptionDAO() {
        return optionDAO;
    }

    @Autowired
    public void setOptionDAO(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    @Override
    public Set<Tariff> getAvailableTariffs() {
        return tariffDAO.all();
    }

    @Override
    public void changeTariff(Contract customerContract, Tariff newTariff) {
        customerContract.setTariff(newTariff);
        contractDAO.update(customerContract);
    }

    @Override
    public final Set<Option> getAvailableOptions(final Tariff tariff) {
        Set<Option> options = tariffDAO.getOptions(tariff);
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
        //check options relatedness
        for (Option ao : tariff.getOptions()) {
            //check if missed related options
            for (Option ro : ao.getOptionsForRelId2()) {
                if (!tariff.getOptions().contains(ro)) {
                    throw new ECareException("Options " + ao.getName() + " and "
                            + ro.getName() + " are related!");
                }
            }
        }
        tariffDAO.update(tariff);
    }

}
