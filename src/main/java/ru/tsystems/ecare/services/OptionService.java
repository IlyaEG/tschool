package ru.tsystems.ecare.services;

import java.util.List;
import java.util.Set;

import ru.tsystems.ecare.persistence.entities.Option;

public interface OptionService {

    List<Option> getAllOptions();

    void createOption(Option newOption);

    void deleteOption(Option oldOption);

    void setIncompatibility(String mainOption, String incompatiobleOption);

    void setRelatedness(String mainOption, String relatedOption);

    Set<Option> getIncompatibile(String option);

    Set<Option> getRelated(String option);

    Option findByName(String name);

}
