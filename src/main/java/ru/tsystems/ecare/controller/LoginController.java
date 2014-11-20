package ru.tsystems.ecare.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller
//@RequestMapping("/")
public class LoginController {

//    @Autowired
//    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("today", new Date());
        return "home";
    }

//    public void execute() {
//        String login = this.getRequest().getParameter("login");
//        String password = this.getRequest().getParameter("password");
//        if (login.length() > 0 && password.length() > 0) {
//            Person person = loginService.userValid(login, password);
//            if (person != null) {
//                HttpSession session = this.getRequest().getSession(true);
//                String role = loginService.userRole(login).getName();
//                session.setAttribute("role", role);
//                session.setAttribute("login", login);
//                switch (role) {
//                    case "employee":
//                        session.setAttribute("user", person.getName());
//                        this.setReturnPage("/controlPanel.jsp"); // logged-in page for employee
//                        break;
//                    case "customer":
//                        session.setAttribute("customer", loginService.findByEmail(login));
//                        this.setReturnPage("/customerPanel.jsp");// logged-in page for customer
//                        break;
//                    default:
//                        this.setReturnPage("/invalidLogin.jsp"); // error page
//                        break;
//                }
//            } else {
//                this.setReturnPage("/invalidLogin.jsp"); // error page
//            }
//        } else {
//            this.setReturnPage("/invalidLogin.jsp"); // error page
//        }
//    }
}
