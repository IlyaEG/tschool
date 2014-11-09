package ru.tsystems.ecare.persistence.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.entities.Option;

@Repository("optionDAO")
public class OptionDAOImpl extends HibernateDAO<Option, Integer>
        implements OptionDAO {

    @Override
    public Option findByName(String name) {
        Query query = currentSession()
                .getNamedQuery("findOptionByName")
                .setString("optionName", name);
        return (Option) query.uniqueResult();
    }

    @Override
    public void setIncompatibility(Option mainOption,
            Option incompatiobleOption) {
        //TODO
        throw new UnsupportedOperationException("not implemented yet!!");

    }

}
