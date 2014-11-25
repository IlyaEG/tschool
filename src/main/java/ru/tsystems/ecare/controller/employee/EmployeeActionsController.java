package ru.tsystems.ecare.controller.employee;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Person;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.CustomerService;
import ru.tsystems.ecare.services.LoginService;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.TariffService;

/**
 *
 * @author ilya
 */
@Controller
@RequestMapping("/employee")
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class EmployeeActionsController {

    private CustomerService customerService;
    private ContractService contractService;
    private TariffService tariffService;
    private OptionService optionService;
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    @Autowired
    public void setTariffService(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @Autowired
    public void setOptionService(OptionService optionService) {
        this.optionService = optionService;
    }

    @RequestMapping
    public final String getEmployeePage(final Model model) {
        Authentication auth = SecurityContextHolder.
                getContext().
                getAuthentication();
        String email = auth.getName(); //get logged in email
        String userName = loginService.getNameByEmail(email);
        model.addAttribute("userName", userName);
        return "employee/home";
    }

    @RequestMapping("/allCustomers")
    public final String getAllCustomers(final Model model) {
        Set<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "employee/allCustomers";
    }

    @RequestMapping("/allContracts")
    public final String getAllContracts(final Model model) {
        Set<Contract> contracts = contractService.getAllContracts();
        model.addAttribute("contracts", contracts);
        model.addAttribute("owners", "of all customers");
        return "employee/allContracts";
    }

    @RequestMapping("/getCustomersContracts")
    public final String getCustomersContracts(final Model model,
            final HttpServletRequest httpServletRequest) {
        String customersPassport = httpServletRequest.getParameter("passport");
        Customer customer = customerService.findByPassport(customersPassport);
        Set<Contract> contracts = customerService.getAllContracts(customer);
        model.addAttribute("contracts", contracts);
        model.addAttribute("owners", customer.getPerson().getName()
                + " " + customer.getPerson().getSurname());
        return "employee/allContracts";
    }

    @RequestMapping("/allTariffs")
    public final String getAllTariffs(final Model model) {
        Set<Tariff> tariffs = tariffService.getAvailableTariffs();
        model.addAttribute("tariffs", tariffs);
        return "employee/allTariffs";
    }

    @RequestMapping("/allOptions")
    public final String getAllOptions(final Model model) {
        Set<Option> options = optionService.getAllOptions();
        model.addAttribute("options", options);
        return "employee/allOptions";
    }

    @RequestMapping("/searchCustomer")
    public final String searchCustomer(final Model model,
            final HttpServletRequest request) {
        try {
            int number = Integer.parseInt(request.getParameter("number"));
            Customer customer = customerService.findByNumber(number);
            model.addAttribute("customer", customer);
            return "employee/searchCustomer";
        } catch (NumberFormatException nfe) {
            model.addAttribute("message",
                    "Please input right contract number!");
            return "employee/searchCustomer";
        } catch (NullPointerException npe) {
            model.addAttribute("message",
                    "No contracts with this number!");
            return "employee/searchCustomer";
        }
    }

    @RequestMapping("/newCustomer")
    public final String newCustomer() {
        return "employee/editCustomer";
    }

    @RequestMapping("/editCustomer")
    public final String editCustomer(final Model model,
            final HttpServletRequest httpServletRequest) {
        String passport = httpServletRequest.getParameter("passport");
        if (passport.length() > 0) {
            Customer customer = customerService.findByPassport(passport);
            if (customer != null) {
                Person person = customer.getPerson();
                model.addAttribute("name", person.getName());
                model.addAttribute("email", person.getEmail());
                model.addAttribute("surname", person.getSurname());
                model.addAttribute("birthdate", person.getBirthdate());
                model.addAttribute("passport", customer.getCustomerPassport());
                model.addAttribute("address", person.getAdress());
                model.addAttribute("password", person.getPassword());
                return "employee/editCustomer";
            }
        }
        return "employee";
    }

    @RequestMapping("/saveCustomer")
    public final String saveCustomer(final Model model,
            final HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        String surname = httpServletRequest.getParameter("surname");
        String birthdate = httpServletRequest.getParameter("birthdate");
        String passport = httpServletRequest.getParameter("passport");
        String address = httpServletRequest.getParameter("address");

        if (name.length() > 0 && email.length() > 0 && password.length() > 0
                && surname.length() > 0 && passport.length() > 0
                && address.length() > 0) {
            //create new customer
            customerService.newCustomer(name, surname, birthdate, email,
                    password, address, passport);
            //todo set tariff
            return "employee/home";
        } else {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("surname", surname);
            model.addAttribute("birthdate", birthdate);
            model.addAttribute("passport", passport);
            model.addAttribute("address", address);
            model.addAttribute("password", password);
            model.addAttribute("message", "Registration Failed!\nFill all fields properly.");
            return "employee/editCustomer";
        }
    }

    @RequestMapping("/newTariff")
    public final String getNewTariffPage(final Model model,
            @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        model.addAttribute("options", optionService.getAllOptions());
        return "employee/newTariff";
    }

    @RequestMapping("/createTariff")
    public final String
            createTariff(final HttpServletRequest httpServletRequest,
                    final Model model) {
        try {
            String name = httpServletRequest.getParameter("name");
            float rate = Float.
                    parseFloat(httpServletRequest.getParameter("rate"));
            Tariff tariff = new Tariff(name, rate);
            Set<Option> activeOptions
                    = getOptions("addOption", httpServletRequest);
            tariff.setOptions(activeOptions);
            tariffService.createTariff(tariff);
            Set<Tariff> tariffs = tariffService.getAvailableTariffs();
            model.addAttribute("tariffs", tariffs);
            return "employee/allTariffs";
        } catch (NumberFormatException nfe) {
            model.addAttribute("message", "Wrong nuber for rate.");
            return "redirect:newTariff";
        } catch (NullPointerException npe) {
            model.addAttribute("message", "All fields are necessary.");
            return "redirect:newTariff";
        }
    }

    protected Set<Option>
            getOptions(final String prefix,
                    final HttpServletRequest httpServletRequest) {
        Enumeration names = httpServletRequest.getParameterNames();
        Set<Option> options = new HashSet<>();
        String temp;
        while (names.hasMoreElements()) {
            temp = (String) names.nextElement();
            if (temp.substring(0, 3).equals(prefix)) {
                options.add(optionService.findByName(temp.substring(3)));
            }
        }
        return options;
    }
}
