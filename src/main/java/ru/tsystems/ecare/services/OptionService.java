package ru.tsystems.ecare.services;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Option;

public interface OptionService {
	List<Option> getAllOptions();
	void createOption(Option newOption);
	void deleteOption(Option oldOption);
	void setIncompatibility(Option mainOption, Option incompatiobleOption);
	void setRelatedness(Option mainOption, Option relatedOption);

}
