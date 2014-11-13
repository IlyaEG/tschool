package ru.tsystems.ecare.persistence.dao.impl;

import java.util.Set;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.TariffDAO;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;

/**
 * Implementation of tariff DAO.
 */
@Repository("tariffDAO")
public class TariffDAOImpl extends HibernateDAO<Tariff, Integer>
        implements TariffDAO {

    @Override
    public final Tariff findByName(final String name) {
        Query query = currentSession()
                .getNamedQuery("findTariffByName")
                .setString("tariffName", name);
        Tariff tariff = (Tariff) query.uniqueResult();
        if (tariff == null) {
            throw new ECareException(
                    "Tariff with name: " + name + "does not exist!");
        }
        return tariff;
    }

    @Override
    public final void addOption(final Tariff tariff, final Option option) {
        Tariff storedTariff = find(tariff.getId());
        if (storedTariff == null) {
            throw new ECareException("Tariff " + tariff.getName()
                    + " not found!");
        }
        if (!storedTariff.getOptions().add(option)) {
            throw new ECareException("Option " + option.getName()
                    + " is alredy assigned for tariff " + tariff.getName());
        }
        update(storedTariff);
    }

    @Override
    public final void removeOption(final Tariff tariff, final Option option) {
        Tariff storedTariff = find(tariff.getId());
        if (storedTariff == null) {
            throw new ECareException("Tariff " + tariff.getName()
                    + " not found!");
        }
        if (!storedTariff.getOptions().remove(option)) {
            throw new ECareException("Option " + option.getName()
                    + " in tariff " + tariff.getName() + " not found!");
        }
        update(storedTariff);
    }

    @Override
    public final Set<Option> getOptions(final Tariff tariff) {
        Tariff storedTariff = find(tariff.getId());
        if (storedTariff == null) {
            throw new ECareException("Tariff " + tariff.getName()
                    + " not found!");
        }
        return storedTariff.getOptions();
    }

}
