/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.impl.OptionServiceImpl;

/**
 *
 * @author ilya
 */
public class NewOptionController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    private static final OptionService optionService = new OptionServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//            try {
//                String name = this.getRequest().getParameter("name");
//                float rate = Float.parseFloat(this.getRequest().getParameter("rate"));
//                float price = Float.parseFloat(this.getRequest().getParameter("price"));
//                optionService.createOption(new Option(name, rate, price));
//
//                this.setReturnPage("/AllOptions");
//
//            }
//            catch (NumberFormatException nfe) {
//                logger.debug(nfe.getMessage());
//                this.getRequest().setAttribute("message", "Wrong nuber for rate or price.");
//                this.setReturnPage("/error.jsp");
//            }
//            catch (NullPointerException npe) {
//                logger.debug(npe.getMessage());
//                this.getRequest().setAttribute("message", "All fields are necessary.");
//                this.setReturnPage("/error.jsp");
//            }
//
//        } else {
//            this.getRequest().getSession(false).invalidate();
//            this.setReturnPage("/index.jsp");
//        }
//    }

}
