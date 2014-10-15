package ru.tsystems.ecare.services;

import java.util.List;

import org.hibernate.HibernateException;

import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.OptionDAOImpl;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class OptionServiceImpl implements OptionService {

	private OptionDAO optionDAO;

	public OptionServiceImpl() {
		optionDAO = new OptionDAOImpl();
	}

	@Override
	public List<Option> getAllOptions() {
		List<Option> allOptions;
		HibernateUtil.beginTransaction();
		allOptions = optionDAO.findAll(Option.class);
		HibernateUtil.commitTransaction();
		return allOptions;
	}

	@Override
	public void createOption(Option newOption) {
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
	public void deleteOption(Option oldOption) {
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
	public void setIncompatibility(Option mainOption, Option incompatiobleOption) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRelatedness(Option mainOption, Option relatedOption) {
		// TODO Auto-generated method stub

	}

}
