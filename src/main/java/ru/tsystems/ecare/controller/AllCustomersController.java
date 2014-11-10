package ru.tsystems.ecare.controller;

import java.util.List;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.impl.CustomerServiceImpl;

/**
 *
 * @author ilya
 */
public class AllCustomersController {

    private static CustomerService customerService = new CustomerServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession().getAttribute("role").equals("employee")) {
//            List<Customer> customers = customerService.getAllCustomers();
//            this.getRequest().setAttribute("customers", customers);
//            this.setReturnPage("/allCustomers.jsp");
//        } else {
//            this.setReturnPage("/index.jsp");
//        }
//
//    }

}
