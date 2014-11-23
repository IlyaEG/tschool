package ru.tsystems.ecare.controller.employee;

import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.impl.ContractServiceImpl;

/**
 *
 * @author ilya
 */
public class EditContractController {

    private static final ContractService contractService = new ContractServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            this.getRequest().setAttribute("contract", contract);
//            this.setReturnPage("/editContract.jsp");
//        } else if (this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            Customer fromSession = (Customer) this.getRequest().getSession(false).getAttribute("customer");
//
//            if (contract.getCustomer().equals(fromSession)) {
//                this.getRequest().setAttribute("contract", contract);
//                this.setReturnPage("/editContract.jsp");
//            } else {
//                this.getRequest().getSession(false).invalidate();
//                this.setReturnPage("/index.jsp");
//            }
//
//        } else {
//            this.getRequest().getSession(false).invalidate();
//            this.setReturnPage("/index.jsp");
//        }
//    }

}
