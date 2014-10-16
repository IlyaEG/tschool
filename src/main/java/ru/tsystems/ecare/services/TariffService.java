package ru.tsystems.ecare.services;
import java.util.List;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;

public interface TariffService {
	
	List<Tariff> getAvailableTariffs();
	
	void changeTariff(Tariff aim);
	
	List<Option> getAvailableOptions();
	
	List<Option> getActiveOptions(Tariff tariff);
	
	void addOption(Option newOption);
	
	void removeOption(Option oldOption);
	
	void createTariff(Tariff newTariff);
	
	void deleteTariff(Tariff oldTariff);
	
}
