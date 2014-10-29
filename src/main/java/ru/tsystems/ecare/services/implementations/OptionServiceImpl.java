package ru.tsystems.ecare.services.implementations;

import ru.tsystems.ecare.services.interfaces.OptionService;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import ru.tsystems.ecare.dto.OptionDTO;

import ru.tsystems.ecare.persistence.dao.interfaces.OptionDAO;
import ru.tsystems.ecare.persistence.dao.implementations.OptionDAOImpl;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class OptionServiceImpl implements OptionService {

    private static final OptionDAO optionDAO = new OptionDAOImpl();

    @Override
    public List<OptionDTO> getAllOptions() {
        List<OptionDTO> allOptions;
        HibernateUtil.beginTransaction();
        allOptions = optionDAO.findAll(OptionDTO.class);
        HibernateUtil.commitTransaction();
        return allOptions;
    }

    @Override
    public void createOption(OptionDTO newOption) {
        try {
            HibernateUtil.beginTransaction();
            optionDAO.save(newOption);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw ex;
        }
    }

    @Override
    public void deleteOption(OptionDTO oldOption) {
        try {
            HibernateUtil.beginTransaction();
            optionDAO.delete(oldOption);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw ex;
        }

    }

    @Override
    public void setIncompatibility(OptionDTO mainOption, OptionDTO incompatibleOption) {
        try {
//            todo
//            HibernateUtil.beginTransaction();
//            optionDAO.findByName(mainOption).getOptionsForIncompId2()
//                    .add(optionDAO.findByName(incompatibleOption));
//            optionDAO.merge(optionDAO.findByName(mainOption));
//            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            throw ex;
        }

    }

    @Override
    public void setRelatedness(OptionDTO mainOption, OptionDTO relatedOption) {
//        todo
//        try {
//            HibernateUtil.beginTransaction();
//            optionDAO.findByName(mainOption).getOptionsForRelId2()
//                    .add(optionDAO.findByName(relatedOption));
//            optionDAO.merge(optionDAO.findByName(mainOption));
//            HibernateUtil.commitTransaction();
//        } catch (HibernateException ex) {
//            HibernateUtil.rollbackTransaction();
//            throw ex;
//        }
    }

    @Override
    public Set<OptionDTO> getIncompatibile(OptionDTO option) {
        HibernateUtil.beginTransaction();
        Set<OptionDTO> incompOptions = null; //todo
        HibernateUtil.commitTransaction();
        return incompOptions;
    }

    @Override
    public Set<OptionDTO> getRelated(OptionDTO option) {
        HibernateUtil.beginTransaction();
        Set<OptionDTO> relOptions = null; //todo
        HibernateUtil.commitTransaction();
        return relOptions;
    }

    @Override
    public OptionDTO findByName(String name) {
        HibernateUtil.beginTransaction();
        OptionDTO finded = optionDAO.findByName(name);
        HibernateUtil.commitTransaction();
        return finded;
    }

}
