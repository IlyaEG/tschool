package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Option;

/**
 * DAO of option.
 */
public interface OptionDAO extends GenericDAO<Option, Integer> {

	void setIncompatibility(Option mainOption, Option incompatiobleOption);
	
	Option findByName(String name);

}
