/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.ecare.exceptions.ECareException;
import ru.tsystems.ecare.services.CustomerService;

/**
 *
 * @author ilya
 */
@Controller
@RequestMapping
public class AccessController {

    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    @Autowired
    public void setCustomerService(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("finishRegistration")
    public final String finishRegistration(
            final HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        String surname = httpServletRequest.getParameter("surname");
        String birthdate = httpServletRequest.getParameter("birthdate");
        String passport = httpServletRequest.getParameter("passport");
        String address = httpServletRequest.getParameter("address");
        String message;
        try {
            if (name.length() > 0 && email.length() > 0 && password.length() > 0
                    && surname.length() > 0 && passport.length() > 0
                    && address.length() > 0) {
            //create new customer

                customerService.saveCustomer(name,
                        surname,
                        birthdate,
                        email,
                        password,
                        address,
                        passport);
                message = "Registration Success! Now you can login.";
                return "redirect:/login?message=" + message;

            } else {
                message = "Registration Failed!\nFill all fields properly.";
            }
        } catch (ECareException e) {
            message = e.getMessage();
        }
        return "redirect:/registration?message=" + message;
    }

    @RequestMapping("/login")
    public final String login(final Model model,
            @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        return "access/login";
    }

    @RequestMapping(value = "/denied")
    public final String denied() {
        return "access/denied";
    }

    @RequestMapping(value = "/login/failure")
    public final String loginFailure() {
        String message = "Login Failure!";
        return "redirect:/login?message=" + message;
    }

    @RequestMapping(value = "/logout/success")
    public final String logoutSuccess() {
        String message = "Logout Success!";
        return "redirect:/login?message=" + message;
    }

    @RequestMapping(value = "/registration")
    public final String registration(final Model model,
            @RequestParam(required = false) final String message) {
        model.addAttribute("message", message);
        return "access/registration";
    }
}
