package ru.tsystems.ecare.persistence.dao;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Option;

/**
 * DAO of option.
 */
public interface OptionDAO extends GenericDAO<Option, Integer> {

    void setIncompatibility(Option mainOption, Option incompatiobleOption);

    void setRelatedness(Option mainOption, Option relatedOption);

    void removeIncompatibility(Option mainOption, Option incompatiobleOption);

    void removeRelatedness(Option mainOption, Option relatedOption);

    Set<Option> getIncompatibleOptions(Option option);

    Set<Option> getRelatedOptions(Option option);

    Option findByName(String name);

}
