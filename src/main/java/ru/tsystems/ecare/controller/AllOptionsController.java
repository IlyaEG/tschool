package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.interfaces.OptionService;
import ru.tsystems.ecare.services.implementations.OptionServiceImpl;

/**
 *
 * @author ilya
 */
public class AllOptionsController extends AbstractController {

	private static final OptionService optionService = new OptionServiceImpl();

	@Override
	public void execute() {
		List<Option> options = optionService.getAllOptions();
		this.getRequest().setAttribute("options", options);
		this.setReturnPage("/allOptions.jsp");
	}

}
