package ru.tsystems.ecare.services;

import java.util.List;

import ru.tsystems.ecare.persistence.entities.Option;

public class OptionServiceImpl implements OptionService {
	
	OptionDAO optionDAO = new OptionDAOImpl();

	@Override
	public List<Option> getAllOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOption(Option newOption) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOption(Option oldOption) {
		// TODO Auto-generated method stub

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
