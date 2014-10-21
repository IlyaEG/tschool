package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class OptionDAOImpl extends GenericDAOImpl<Option, Integer> implements
		OptionDAO {

	@Override
	public Option findByName(String name) {
		Query query = HibernateUtil.getSession()
				.getNamedQuery("findOptionByName").setString("optionName", name);
		return (Option) query.uniqueResult();
	}

	@Override
	public void setIncompatibility(Option mainOption, Option incompatiobleOption) {
		//TODO
		
	}

}
