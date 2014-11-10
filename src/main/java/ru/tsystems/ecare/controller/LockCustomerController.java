/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.impl.CustomerServiceImpl;

/**
 *
 * @author ilya
 */
public class LockCustomerController {

    private static final CustomerService customerService = new CustomerServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//            Customer toLock = customerService.findByPassport(this.
//                    getRequest().getParameter("passport"));
//            if (customerService.isLocked(toLock)) {
//                customerService.unlockCustomer(toLock);
//            } else {
//                customerService.lockCustomer(toLock);
//            }
//            List<Customer> customers = customerService.getAllCustomers();
//            this.getRequest().setAttribute("customers", customers);
//            this.setReturnPage("/allCustomers.jsp");
//
//        } else {
//            this.getRequest().getSession(false).invalidate();
//            this.setReturnPage("/index.jsp");
//        }
//    }

}
