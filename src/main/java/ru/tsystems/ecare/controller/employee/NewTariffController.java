/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller.employee;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.TariffService;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

/**
 *
 * @author ilya
 */
public class NewTariffController {

    private static final TariffService tariffService = new TariffServiceImpl();

//    public void execute() {
//        if (this.getRequest().getSession().getAttribute("role").equals("employee")) {
//            //TODO add options
//            this.setReturnPage("/newTariff.jsp");
//        } else {
//            this.setReturnPage("/index.jsp");
//        }
//
//    }
}