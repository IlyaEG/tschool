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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tsystems.ecare.services.LoginService;

//@Controller
//@RequestMapping("/")
@PreAuthorize("hasRole('ROLE_USER')")
public class MediatorController {

    private LoginService loginService;

    public LoginService getLoginService() {
        return loginService;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/customer")
    public final String getCustomerPage(final Model model) {
        Authentication auth = SecurityContextHolder.
                getContext().
                getAuthentication();
        String email = auth.getName(); //get logged in email
        model.addAttribute("userName", loginService.getNameByEmail(email));
        return "customer/home";
    }

//    @RequestMapping(value = "/employee")
    public final String getEmployeePage(final Model model) {
        Authentication auth = SecurityContextHolder.
                getContext().
                getAuthentication();
        String email = auth.getName(); //get logged in email
        //String userName = loginService.getNameByEmail(email);
        model.addAttribute("userName", email);
        return "employee/home";
    }
}
