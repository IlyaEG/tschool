package ru.tsystems.ecare.services.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.OptionService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@Service("optionService")
public class OptionServiceImpl implements OptionService {

    // dependencies
    private SessionFactory sessionFactory;
    private OptionDAO optionDAO;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Option> getAllOptions() {
        List<Option> allOptions;
        allOptions = optionDAO.list();
        return allOptions;
    }

    @Override
    public void createOption(Option newOption) {
        optionDAO.add(newOption);
    }

    @Override
    public void deleteOption(Option oldOption) {
        optionDAO.remove(oldOption);
    }

    @Override
    public void setIncompatibility(String mainOption, String incompatibleOption) {
        optionDAO.findByName(mainOption).getOptionsForIncompId2()
                .add(optionDAO.findByName(incompatibleOption));
        optionDAO.update(optionDAO.findByName(mainOption));
    }

    @Override
    public void setRelatedness(String mainOption, String relatedOption) {
        optionDAO.findByName(mainOption).getOptionsForRelId2()
                .add(optionDAO.findByName(relatedOption));
        optionDAO.update(optionDAO.findByName(mainOption));
    }

    @Override
    public Set<Option> getIncompatibile(String option) {
        Set<Option> incompOptions = optionDAO.findByName(option).getOptionsForIncompId2();
        return incompOptions;
    }

    @Override
    public Set<Option> getRelated(String option) {
        Set<Option> relOptions = optionDAO.findByName(option).getOptionsForRelId2();
        return relOptions;
    }

    @Override
    public Option findByName(String name) {
        Option finded = optionDAO.findByName(name);
        return finded;
    }

}
