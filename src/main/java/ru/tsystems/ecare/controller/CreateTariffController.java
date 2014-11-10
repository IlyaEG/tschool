/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class CreateTariffController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    private static final TariffService tariffService = new TariffServiceImpl();

//    public void execute() {
//
//        if (this.getRequest().getSession(false).getAttribute("role").equals("employee")) {
//            try {
//                String name = this.getRequest().getParameter("name");
//                float rate = Float.parseFloat(this.getRequest().getParameter("rate"));
//                Tariff tariff = new Tariff(name, rate);
//                tariffService.createTariff(tariff);
//                this.setReturnPage("/AllTariffs");
//            }
//            catch (NumberFormatException nfe) {
//                logger.debug(nfe.getMessage());
//                this.getRequest().setAttribute("message", "Wrong nuber for rate.");
//                this.setReturnPage("/error.jsp");
//            }
//            catch (NullPointerException npe) {
//                logger.debug(npe.getMessage());
//                this.getRequest().setAttribute("message", "All fields are necessary.");
//                this.setReturnPage("/error.jsp");
//            }
//        } else {
//            this.setReturnPage("/index.jsp");
//        }
//
//    }
}
