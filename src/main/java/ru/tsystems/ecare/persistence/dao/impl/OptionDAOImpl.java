package ru.tsystems.ecare.persistence.dao.impl;

import java.util.Set;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.ECareException;
import ru.tsystems.ecare.persistence.dao.OptionDAO;
import ru.tsystems.ecare.persistence.entities.Option;

@Repository("optionDAO")
public class OptionDAOImpl extends HibernateDAO<Option, Integer>
        implements OptionDAO {

    @Override
    public final Option findByName(final String name) {
        Query query = currentSession()
                .getNamedQuery("findOptionByName")
                .setString("optionName", name);
        return (Option) query.uniqueResult();
    }

    @Override
    public final void setIncompatibility(final Option mainOption,
            final Option incompatiobleOption) {
        Option storedMainOption = find(mainOption.getId());
        if (storedMainOption == null) {
            throw new ECareException("Option " + mainOption.getName()
                    + " not found!");
        }
        Option storedIncompatibleOption = find(incompatiobleOption.getId());
        if (storedIncompatibleOption == null) {
            throw new ECareException("Option " + incompatiobleOption.getName()
                    + " not found!");
        }
        if (!storedMainOption.getOptionsForIncompId2()
                .add(storedIncompatibleOption)) {
            throw new ECareException("Options " + incompatiobleOption.getName()
                    + " and " + mainOption.getName()
                    + " are alredy incompatible!");
        }
        update(storedMainOption);
    }

    @Override
    public final void setRelatedness(final Option mainOption,
            final Option relatedOption) {
        Option storedMainOption = find(mainOption.getId());
        if (storedMainOption == null) {
            throw new ECareException("Option " + mainOption.getName()
                    + " not found!");
        }
        Option storedRelatedOption = find(relatedOption.getId());
        if (storedRelatedOption == null) {
            throw new ECareException("Option " + relatedOption.getName()
                    + " not found!");
        }
        if (!storedMainOption.getOptionsForRelId2()
                .add(storedRelatedOption)) {
            throw new ECareException("Options " + relatedOption.getName()
                    + " and " + mainOption.getName()
                    + " are alredy related!");
        }
        update(storedMainOption);
    }

    @Override
    public final void removeIncompatibility(final Option mainOption,
            final Option incompatiobleOption) {
        Option storedMainOption = find(mainOption.getId());
        if (storedMainOption == null) {
            throw new ECareException("Option " + mainOption.getName()
                    + " not found!");
        }
        Option storedIncompatibleOption = find(incompatiobleOption.getId());
        if (storedIncompatibleOption == null) {
            throw new ECareException("Option " + incompatiobleOption.getName()
                    + " not found!");
        }
        if (!storedMainOption.getOptionsForIncompId2()
                .remove(storedIncompatibleOption)) {
            throw new ECareException("Options " + incompatiobleOption.getName()
                    + " and " + mainOption.getName()
                    + " are not incompatible!");
        }
        update(storedMainOption);
    }

    @Override
    public final void removeRelatedness(final Option mainOption,
            final Option relatedOption) {
        Option storedMainOption = find(mainOption.getId());
        if (storedMainOption == null) {
            throw new ECareException("Option " + mainOption.getName()
                    + " not found!");
        }
        Option storedRelatedOption = find(relatedOption.getId());
        if (storedRelatedOption == null) {
            throw new ECareException("Option " + relatedOption.getName()
                    + " not found!");
        }
        if (!storedMainOption.getOptionsForRelId2()
                .remove(storedRelatedOption)) {
            throw new ECareException("Options " + relatedOption.getName()
                    + " and " + mainOption.getName()
                    + " are not related!");
        }
        update(storedMainOption);
    }

    @Override
    public final Set<Option> getIncompatibleOptions(final Option option) {
        Option storedOption = find(option.getId());
        if (storedOption == null) {
            throw new ECareException("Option " + option.getName()
                    + " not found!");
        }
        return storedOption.getOptionsForIncompId2();
    }

    @Override
    public final Set<Option> getRelatedOptions(final Option option) {
        Option storedOption = find(option.getId());
        if (storedOption == null) {
            throw new ECareException("Option " + option.getName()
                    + " not found!");
        }
        return storedOption.getOptionsForRelId2();
    }

}
