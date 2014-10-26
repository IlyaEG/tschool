package ru.tsystems.ecare.controller;

import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.ContractServiceImpl;

/**
 *
 * @author ilya
 */
public class EditContractController extends AbstractController {

	private static final ContractService contractService = new ContractServiceImpl();
	
	@Override
	public void execute() {
		if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
			int number = Integer.parseInt(this.getRequest().getParameter("number"));
			Contract contract = contractService.findByNumber(number);
			this.getRequest().setAttribute("contract", contract);
			this.setReturnPage("/editContract.jsp");
			
		} else {
			this.getRequest().getSession(false).invalidate();
			this.setReturnPage("/index.jsp");
		}
	}
	
}
