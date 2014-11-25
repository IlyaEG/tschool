/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ilya
 */
@Controller
@RequestMapping
public class AccessController {

    @RequestMapping("/login")
    public final String login(Model model,
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
    public final String registration() {
        String message = "Logout Success!";
        return "access/registration";
    }
}
