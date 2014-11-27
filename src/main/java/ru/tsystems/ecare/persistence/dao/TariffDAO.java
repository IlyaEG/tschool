package ru.tsystems.ecare.persistence.dao;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;

/**
 * DAO of tariff.
 */
public interface TariffDAO extends GenericDAO<Tariff, Integer> {

    /**
     * Tries to search tariff by name. Else throw {@code ECareException}.
     *
     * @param name Tariff name for search
     * @return {@code Tariff} if tariff is found.
     */
    Tariff findByName(String name);

    /**
     * Tries to add option to tariff's available options list. Else throw
     * {@code ECareException}.
     *
     * @param tariff Tariff to search option.
     * @param option Option to add.
     */
    void addOption(Tariff tariff, Option option);

    /**
     * Tries to remove option from tariff's available options list. Else throw
     * {@code ECareException}.
     *
     * @param tariff Tariff to search option
     * @param option Option to remove
     */
    void removeOption(Tariff tariff, Option option);

    /**
     * Tries to get options list from tariff. Else throw {@code ECareException}.
     *
     * @param tariff Tariff to search options
     * @return {@code Set<Option>} if tariff has options.
     */
    Set<Option> getOptions(Tariff tariff);

}
