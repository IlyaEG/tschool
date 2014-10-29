package ru.tsystems.ecare.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.interfaces.TariffService;
import ru.tsystems.ecare.services.implementations.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class AllTariffsController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(AllTariffsController.class);

	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee") ||
				this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
		List<Tariff> tariffs = tariffService.getAvailableTariffs();
		this.getRequest().setAttribute("tariffs", tariffs);
		this.setReturnPage("/allTariffs.jsp");
		} else {
			this.getRequest().getSession(false).invalidate();
			logger.debug("Unauthorized attempt to access to AllTariffsController.");
			this.setReturnPage("/index.jsp");
		}
	}

}
