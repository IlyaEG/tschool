package ru.tsystems.ecare.persistence.dao;

import org.hibernate.Query;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.persistence.utils.HibernateUtil;

public class TariffDAOImpl extends GenericDAOImpl<Tariff, Integer> implements TariffDAO {

	

	@Override
	public Tariff findByName(String name) {
		Query query = HibernateUtil.getSession()
				.getNamedQuery("findTariffByName").setString("tariffName", name);
		return (Tariff) query.uniqueResult();
	}

	@Override
	public Tariff getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
