package ru.tsystems.ecare.persistence.dao.interfaces;

import ru.tsystems.ecare.dto.OptionDTO;
import ru.tsystems.ecare.persistence.entities.Option;

public interface OptionDAO extends GenericDAO<OptionDTO, Option> {

    void setIncompatibility(OptionDTO mainOption,
            OptionDTO incompatiobleOption);

    OptionDTO findByName(String name);

}
