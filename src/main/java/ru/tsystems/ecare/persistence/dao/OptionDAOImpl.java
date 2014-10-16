package ru.tsystems.ecare.persistence.dao;

import java.util.Set;

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
	
	
	/*
	 * private static final Logger logger = LoggerFactory
			.getLogger(this.class);
	 * 
	 * 
	 * logger.debug("saving entity " + entity.toString());
		try {
	 */

}
