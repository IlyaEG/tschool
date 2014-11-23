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
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.impl.CustomerServiceImpl;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

public class SetTariffController {

    private static final ContractService contractService = new ContractServiceImpl();
    private static final TariffService tariffService = new TariffServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            int id = Integer.parseInt(this.getRequest().getParameter("tariff"));
//            Tariff tariff = tariffService.findById(id);
//            tariffService.changeTariff(contract, tariff);
//            List<Contract> contracts = contractService.getAllContracts();
//            this.getRequest().setAttribute("contracts", contracts);
//            this.setReturnPage("/allContracts.jsp");
//
//        } else if (this.getRequest().getSession(false).getAttribute("role").equals("customer")) {
//
//            int number = Integer.parseInt(this.getRequest().getParameter("number"));
//            Contract contract = contractService.findByNumber(number);
//            Customer fromSession = (Customer) this.getRequest().getSession(false).getAttribute("customer");
//
//            if (contract.getCustomer().equals(fromSession)) {
//
//                int id = Integer.parseInt(this.getRequest().getParameter("tariff"));
//                Tariff tariff = tariffService.findById(id);
//                tariffService.changeTariff(contract, tariff);
//                Customer customer = customerService.findByNumber(contract.getNumber());
//                this.getRequest().setAttribute("customer", customer);
//                this.setReturnPage("/customerPanel.jsp");
//
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
