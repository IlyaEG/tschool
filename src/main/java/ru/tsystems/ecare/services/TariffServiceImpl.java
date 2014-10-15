package ru.tsystems.ecare.services;

import java.util.List;

import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.dao.TariffDAOImpl;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class TariffServiceImpl implements TariffService {
	
	private TariffDAO tariffDAO;
	
	public TariffServiceImpl() {
		tariffDAO = new TariffDAOImpl();
	}

	@Override
	public List<Tariff> getAvailableTariffs() {
		List<Tariff> availableTariffs;
		HibernateUtil.beginTransaction();
		availableTariffs = tariffDAO.findAll(Tariff.class);
		HibernateUtil.commitTransaction();
		return availableTariffs;
	}

	@Override
	public void changeTariff(Tariff aim) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Option> getAvailableOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Option> getActiveOptions(Tariff tariff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOption(Option newOption) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOption(Option oldOption) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTariff(Tariff newTariff) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTariff(Tariff oldTariff) {
		// TODO Auto-generated method stub

	}

}
