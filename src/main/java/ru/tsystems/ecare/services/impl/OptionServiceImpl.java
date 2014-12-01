package ru.tsystems.ecare.services.impl;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.OptionService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("optionService")
public class OptionServiceImpl implements OptionService {

    // dependencies
    private SessionFactory sessionFactory;
    private OptionDAO optionDAO;
    private TariffDAO tariffDAO;

    public TariffDAO getTariffDAO() {
        return tariffDAO;
    }

    @Autowired
    public void setTariffDAO(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    public final OptionDAO getOptionDAO() {
        return optionDAO;
    }

    @Autowired
    public final void setOptionDAO(final OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    @Autowired
    public final void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public final SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public final Set<Option> getAllOptions() {
        return optionDAO.all();
    }

    @Override
    public final void createOption(final Option newOption) {
        optionDAO.add(newOption);
    }

    @Override
    public final void deleteOption(final Option oldOption) {
        optionDAO.remove(oldOption);
    }

    @Override
    public final void setIncompatibility(final String mainOption,
            final String incompatibleOption) {
        optionDAO.setIncompatibility(
                findByName(mainOption),
                findByName(incompatibleOption));
    }

    @Override
    public final void setRelatedness(final String mainOption,
            final String relatedOption) {
        optionDAO.setRelatedness(
                findByName(mainOption),
                findByName(relatedOption));
        //update all tariffs
        Set<Tariff> tariffs = tariffDAO.all();
        for (Tariff tariff : tariffs) {
            if (tariff.getOptions().contains(findByName(relatedOption))
                    && !tariff.getOptions().
                    contains(findByName(mainOption))) {
                tariffDAO.addOption(tariff, findByName(mainOption));
            }
        }
    }

    @Override
    public final Set<Option> getIncompatibile(final String option) {
        return optionDAO.getIncompatibleOptions(findByName(option));
    }

    @Override
    public final Set<Option> getRelated(final String option) {
        return optionDAO.getRelatedOptions(findByName(option));
    }

    @Override
    public final Option findByName(final String name) {
        Option finded = optionDAO.findByName(name);
        return finded;
    }

    @Override
    public final Option findByID(final int id) {
        return optionDAO.find(id);
    }

    @Override
    public final void saveOption(final Option option) {
        optionDAO.update(option);
    }

    @Override
    public final void independentOption(final Option option) {
        Set<Option> temp = option.getOptionsForIncompId2();
        for (Option o : temp) {
            optionDAO.removeIncompatibility(option, o);
        }
        temp = option.getOptionsForRelId2();
        for (Option o : temp) {
            optionDAO.removeRelatedness(option, o);
        }
    }

}
