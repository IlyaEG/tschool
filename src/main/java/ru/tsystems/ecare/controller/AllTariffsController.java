package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class AllTariffsController extends AbstractController {

	private static final TariffService tariffService = new TariffServiceImpl();

	@Override
	public void execute() {
		List<Tariff> tariffs = tariffService.getAvailableTariffs();
		this.getRequest().setAttribute("tariffs", tariffs);
		this.setReturnPage("/allTariffs.jsp");
	}

}
