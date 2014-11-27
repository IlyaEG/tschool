package ru.tsystems.ecare.services;

import java.util.Set;
import ru.tsystems.ecare.persistence.entities.Contract;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;

public interface TariffService {

    Set<Tariff> getAvailableTariffs();

    void changeTariff(Contract customerContract, Tariff newTariff);

    Set<Option> getAvailableOptions(Tariff tariff);

    void updateTariff(Tariff tariff);

    void createTariff(Tariff newTariff);

    void deleteTariff(Tariff oldTariff);

    public Tariff findById(int id);

}
