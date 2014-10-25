package ru.tsystems.ecare.services;
import java.util.List;
import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Customer;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;

public interface TariffService {
	
	List<Tariff> getAvailableTariffs();
	
	void changeTariff(Customer customer, Tariff newTariff);
	
	Set<Option> getAvailableOptions(Tariff tariff);
	
	Set<Option> getActiveOptions(Tariff tariff);
	
	void addOption(Option newOption);
	
	void removeOption(Option oldOption);
	
	void createTariff(Tariff newTariff);
	
	void deleteTariff(Tariff oldTariff);
	
}
