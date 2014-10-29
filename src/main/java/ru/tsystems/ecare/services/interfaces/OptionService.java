package ru.tsystems.ecare.services.interfaces;

import java.util.List;
import java.util.Set;
import ru.tsystems.ecare.dto.OptionDTO;

public interface OptionService {

    List<OptionDTO> getAllOptions();

    void createOption(OptionDTO newOption);

    void deleteOption(OptionDTO oldOption);

    void setIncompatibility(OptionDTO mainOption,
            OptionDTO incompatiobleOption);

    void setRelatedness(OptionDTO mainOption, OptionDTO relatedOption);

    Set<OptionDTO> getIncompatibile(OptionDTO option);

    Set<OptionDTO> getRelated(OptionDTO option);

    OptionDTO findByName(String name);

}
