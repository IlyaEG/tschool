package ru.tsystems.ecare.services.interfaces;

import java.util.List;
import ru.tsystems.ecare.dto.ContractDTO;
import ru.tsystems.ecare.dto.OptionDTO;
import ru.tsystems.ecare.dto.TariffDTO;

public interface TariffService {

    List<TariffDTO> getAvailableTariffs();

    void changeTariff(ContractDTO customerContract);

    List<OptionDTO> getAvailableOptions();

    void updateTariff(TariffDTO tariff);

    void createTariff(TariffDTO newTariff);

    void deleteTariff(TariffDTO oldTariff);

    public TariffDTO findById(int id);

}
