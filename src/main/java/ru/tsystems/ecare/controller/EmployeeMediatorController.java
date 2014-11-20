/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

/**
 * Is responsible for handling requests to common pages such as customer and
 * employee pages
 *
 * @author ilya
 */
import java.util.Date;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class EmployeeMediatorController {

    @RequestMapping()
    public final String getEmployeePage() {
        return "employee/home";
    }

    @RequestMapping(value = "customersNContracts")
    public final String getCustomersNContractsPage() {
        return "employee/customersNContracts";
    }

    @RequestMapping(value = "tariffsNOptions")
    public final String getTariffsNOptionsPage() {
        return "employee/tariffsNOptions";
    }
}
