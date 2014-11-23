/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller.common;

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
@RequestMapping("/")
@PreAuthorize("hasRole('ROLE_USER')")
public class MediatorController {

    @RequestMapping("/customer")
    public final String getCustomerPage() {
        return "customer/home";
    }

    @RequestMapping(value = "/employee")
    public final String getEmployeePage() {
        return "employee/home";
    }
}
