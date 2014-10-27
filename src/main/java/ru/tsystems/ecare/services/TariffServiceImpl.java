package ru.tsystems.ecare.services;

import java.util.List;
import org.hibernate.HibernateException;
import ru.tsystems.ecare.persistence.dao.ContractDAO;
import ru.tsystems.ecare.persistence.dao.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.dao.OptionDAOImpl;

import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.dao.TariffDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class TariffServiceImpl implements TariffService {

	private static final TariffDAO tariffDAO = new TariffDAOImpl();
	private static final ContractDAO contractDAO = new ContractDAOImpl();
	private static final OptionDAO optionDAO = new OptionDAOImpl();

	public TariffServiceImpl() {
	}

	@Override
	public List<Tariff> getAvailableTariffs() {
		HibernateUtil.beginTransaction();
		List<Tariff> availableTariffs = tariffDAO.findAll(Tariff.class);
		HibernateUtil.commitTransaction();
		return availableTariffs;
	}

	@Override
	public void changeTariff(Contract customerContract, Tariff newTariff) {
		HibernateUtil.beginTransaction();
		customerContract.setTariff(newTariff);
		contractDAO.save(customerContract);
		HibernateUtil.commitTransaction();
	}

	@Override
	public List<Option> getAvailableOptions() {
		HibernateUtil.beginTransaction();
		List<Option> options = optionDAO.findAll(Option.class);
		HibernateUtil.commitTransaction();
		return options;
	}

	@Override
	public void createTariff(Tariff newTariff) {
		try {
			HibernateUtil.beginTransaction();
			tariffDAO.save(newTariff);
			HibernateUtil.commitTransaction();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}
	}

	@Override
	public void deleteTariff(Tariff oldTariff) {
		try {
			HibernateUtil.beginTransaction();
			tariffDAO.delete(oldTariff);
			HibernateUtil.commitTransaction();
		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			throw ex;
		}

	}

	@Override
	public Tariff findById(int id) {
		HibernateUtil.beginTransaction();
		Tariff tariff = tariffDAO.findByID(Tariff.class, id);
		HibernateUtil.commitTransaction();
		return tariff;
	}

	@Override
	public void updateTariff(Tariff tariff) {
		HibernateUtil.beginTransaction();
		tariffDAO.save(tariff);
		HibernateUtil.commitTransaction();
	}

}
