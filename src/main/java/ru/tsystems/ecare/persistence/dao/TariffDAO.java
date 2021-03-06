package ru.tsystems.ecare.persistence.dao;

import ru.tsystems.ecare.persistence.entities.Tariff;

public interface TariffDAO extends GenericDAO<Tariff, Integer> {
	
	Tariff findByName(String name);

}
