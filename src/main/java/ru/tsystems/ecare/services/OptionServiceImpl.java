package ru.tsystems.ecare.services;

import java.util.List;
import java.util.Set;

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
	public void setIncompatibility(String mainOption, String incompatibleOption) {
		try {
			HibernateUtil.beginTransaction();
			optionDAO.findByName(mainOption).getOptionsForIncompId2()
					.add(optionDAO.findByName(incompatibleOption));
			optionDAO.merge(optionDAO.findByName(mainOption));
			HibernateUtil.commitTransaction();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}

	}

	@Override
	public void setRelatedness(String mainOption, String relatedOption) {
		try {
			HibernateUtil.beginTransaction();
			optionDAO.findByName(mainOption).getOptionsForRelId2()
					.add(optionDAO.findByName(relatedOption));
			optionDAO.merge(optionDAO.findByName(mainOption));
			HibernateUtil.commitTransaction();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}
	}

	@Override
	public Set<Option> getIncompatibile(String option) {
		HibernateUtil.beginTransaction();
		Set<Option> incompOptions = optionDAO.findByName(option).getOptionsForIncompId2();
		HibernateUtil.commitTransaction();
		return incompOptions;
	}

	@Override
	public Set<Option> getRelated(String option) {
		HibernateUtil.beginTransaction();
		Set<Option> relOptions = optionDAO.findByName(option).getOptionsForRelId2();
		HibernateUtil.commitTransaction();
		return relOptions;
	}

	@Override
	public Option findByName(String name) {
		Option finded;
		HibernateUtil.beginTransaction();
		finded = optionDAO.findByName(name);
		HibernateUtil.commitTransaction();
		return finded;
	}

}
