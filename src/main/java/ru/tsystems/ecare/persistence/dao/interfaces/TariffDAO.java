package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.TariffDTO;
import ru.tsystems.ecare.persistence.entities.Tariff;

public interface TariffDAO extends GenericDAO<TariffDTO, Tariff> {

    TariffDTO findByName(String name);

}
