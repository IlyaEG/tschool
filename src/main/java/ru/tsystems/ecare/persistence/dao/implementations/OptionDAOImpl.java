package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.OptionDAO;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.OptionDTO;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class OptionDAOImpl extends GenericDAOImpl<OptionDTO, Option>
        implements OptionDAO {

    @Override
    public OptionDTO findByName(String name) {
        Query query = HibernateUtil.getSession()
                .getNamedQuery("findOptionByName")
                .setString("optionName", name);
        Option option = (Option) query.uniqueResult();
        OptionDTO optionDTO = new OptionDTO();
        return optionDTO.readEntity(option);
    }

    @Override
    public void setIncompatibility(OptionDTO mainOption, OptionDTO incompatiobleOption) {
        //TODO

    }

}
