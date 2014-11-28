package ru.tsystems.ecare.controller;

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.tsystems.ecare.exceptions.ECareException;
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
@RequestMapping("/customer")
@PreAuthorize("hasRole('ROLE_CUSTOMER')")
public class CustomerActionsController {

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
    public final String getCustomerPage(final Model model) {
        String email = getLogin();
        String userName = loginService.getNameByEmail(email);
        model.addAttribute("userName", userName);
        return "customer/home";
    }

    private String getLogin() {
        Authentication auth = SecurityContextHolder.
                getContext().
                getAuthentication();
        String email = auth.getName(); //get logged in email
        return email;
    }

    @RequestMapping("/allContracts")
    public final String getAllContracts(final Model model) {
        Customer customer = loginService.findByEmail(getLogin());
        Set<Contract> contracts = customerService.getAllContracts(customer);
        model.addAttribute("contracts", contracts);
        model.addAttribute("customer", customer);
        return "customer/allContracts";
    }

    @RequestMapping("/allTariffs")
    public final String getAllTariffs(final Model model) {
        Set<Tariff> tariffs = tariffService.getAvailableTariffs();
        model.addAttribute("tariffs", tariffs);
        return "customer/allTariffs";
    }

    @RequestMapping("/allOptions")
    public final String getAllOptions(final Model model) {
        Set<Option> options = optionService.getAllOptions();
        model.addAttribute("options", options);
        return "customer/allOptions";
    }

    @RequestMapping("/about")
    public final String editCustomer(final Model model) {
        Customer customer = loginService.findByEmail(getLogin());
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/about";
        }
        return getCustomerPage(model);
    }

    @RequestMapping("/changePassword")
    public final String saveCustomer(final Model model,
            final HttpServletRequest httpServletRequest) {
        String password = httpServletRequest.getParameter("password");
        Customer customer = loginService.findByEmail(getLogin());
        try {
            customerService.changePassword(customer, password);
        } catch (ECareException e) {
            model.addAttribute("customer", customer);
            model.addAttribute("message", e.getMessage());
            return "customer/about";
        }
        return getCustomerPage(model);
    }

    @RequestMapping(value = "contractTariff/{number}")
    public final String getTariffChangingPage(
            @PathVariable("number") final int number, final Model model) {
        Contract contract = contractService.findByNumber(number, getLogin());

        if (contract.getLockedBy() == null) {
            model.addAttribute("customer", contract.getCustomer());
            model.addAttribute("contract", contract);
            model.addAttribute("availableTariffs",
                    tariffService.getAvailableTariffs());
            return "customer/customersTariff";
        } else {
            model.addAttribute("message", "Contract locked!");
            return getAllContracts(model);
        }
    }

    @RequestMapping(value = "changeTariff")
    public final String changeContractTariff(final Model model,
            final HttpServletRequest httpServletRequest) {
        Contract contract = contractService.
                findByNumber(Integer.parseInt(httpServletRequest.
                                getParameter("number")), getLogin());
        Tariff newTariff = tariffService.
                findById(Integer.parseInt(httpServletRequest.
                                getParameter("tariff")));
        contract.setTariff(newTariff);
        contractService.save(contract, getLogin());
        
        return getAllContracts(model);
    }

    @RequestMapping(value = "contractOptions/{number}")
    public final String getContractOptionsPage(
            @PathVariable("number") int number, Model model) {
        Contract contract = contractService.findByNumber(number, getLogin());
        //set current contract
        model.addAttribute("contract", contract);
        //available options this contract's tariff excluding already added.
        Set<Option> availableOptions
                = tariffService.getAvailableOptions(contract.getTariff());
        for (Option o : contract.getOptions()) {
            availableOptions.remove(o);
        }
        model.addAttribute("availableOptions", availableOptions);
        return "customer/customersOptions";
    }

    @RequestMapping(value = "changeContractOptions")
    public final String changeContractOptions(final Model model,
            final HttpServletRequest httpServletRequest) {
        Contract contract = contractService.
                findByNumber(Integer.parseInt(httpServletRequest.
                                getParameter("number")), getLogin());
        Set<Option> add = getOptions("addOption", httpServletRequest);
        Set<Option> rem = getOptions("remOption", httpServletRequest);
        Set<Option> activeOptions = contract.getOptions();
        for (Option o : add) {
            activeOptions.add(o);
        }
        for (Option o : rem) {
            activeOptions.remove(o);
        }
        contractService.setOptions(contract, activeOptions, getLogin());

        
        return getAllContracts(model);
    }

//get set of options from request with specified prefix
    protected Set<Option> getOptions(final String prefix,
            final HttpServletRequest httpServletRequest) {
        Enumeration names = httpServletRequest.getParameterNames();
        Set<Option> options = new HashSet<>();
        String temp;
        while (names.hasMoreElements()) {
            temp = (String) names.nextElement();
            if (temp.length() > prefix.length()
                    && temp.substring(0, prefix.length()).equals(prefix)) {
                options.add(optionService.findByName(
                        temp.substring(prefix.length())));
            }
        }
        return options;
    }

    //get set of customers from request with specified prefix
    protected Set<Customer> getCustomers(final String prefix,
            final HttpServletRequest httpServletRequest) {
        Enumeration names = httpServletRequest.getParameterNames();
        Set<Customer> customers = new HashSet<>();
        String temp;
        while (names.hasMoreElements()) {
            temp = (String) names.nextElement();
            if (temp.length() > prefix.length()
                    && temp.substring(0, prefix.length()).equals(prefix)) {
                customers.add(customerService.findByPassport(
                        temp.substring(prefix.length())));
            }
        }
        return customers;
    }

    @RequestMapping(value = "lockContract/{number}")
    public final String lockContract(
            @PathVariable("number") final int number,
            final Model model) {
        try {
            Contract contract = contractService.
                    findByNumber(number, getLogin());

            if (contract.getLockedBy() != null) {
                contractService.unlockNumber(contract.getNumber(), getLogin());

            } else {
                contractService.lockNumber(contract.getNumber(), getLogin());
            }

        } catch (ECareException e) {
            model.addAttribute("message", e.getMessage());
        }

        return getAllContracts(model);
    }

    /**
     * Handles EcareException.
     *
     * @param e Thrown exception with error message
     * @return binds message to model and returns customer/error
     */
    @ExceptionHandler(ECareException.class)
    public final ModelAndView handleECareException(final ECareException e) {
        ModelMap model = new ModelMap();
        model.put("message", e.getMessage());
        return new ModelAndView("customer/error", model);
    }

    /**
     * Handles Exception.
     *
     * @param e Thrown exception with error message
     * @return binds message to model and returns customer/error
     */
    @ExceptionHandler(Exception.class)
    public final ModelAndView handleException(final Exception e) {
        ModelMap model = new ModelMap();
        model.put("message", e.getMessage());
        return new ModelAndView("customer/error", model);
    }
}
