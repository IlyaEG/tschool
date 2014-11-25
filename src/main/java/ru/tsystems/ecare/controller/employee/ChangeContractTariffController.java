/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller.employee;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.impl.ContractServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

public class ChangeContractTariffController {

    private static final ContractService contractService = new ContractServiceImpl();
    private static final TariffService tariffService = new TariffServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            this.getRequest().setAttribute("contract", contract);
//            List<Tariff> availableTariffs = tariffService.getAvailableTariffs();
//            this.getRequest().setAttribute("tariffs", availableTariffs);
//            this.setReturnPage("/chooseNewTariff.jsp");
//        } else if (this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            Customer fromSession = (Customer) this.getRequest().getSession(false).getAttribute("customer");
//
//            if (contract.getCustomer().equals(fromSession)) {
//
//                this.getRequest().setAttribute("contract", contract);
//                List<Tariff> availableTariffs = tariffService.getAvailableTariffs();
//                this.getRequest().setAttribute("tariffs", availableTariffs);
//                this.setReturnPage("/chooseNewTariff.jsp");
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
