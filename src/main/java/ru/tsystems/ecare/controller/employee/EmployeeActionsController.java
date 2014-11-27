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
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("customer", customer);
        model.addAttribute("owners", "of " + customer.getPerson().getName()
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
            Set<Contract> contracts = contractService.findAnyByNumber(number);
            model.addAttribute("contracts", contracts);
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
    public final String newCustomer(final Model model) {
        model.addAttribute("new", "1");
        model.addAttribute("availableTariffs",
                tariffService.getAvailableTariffs());
        model.addAttribute("availableNumbers",
                contractService.getAvailableNumbers());
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
        String tariff = httpServletRequest.getParameter("tariff");
        String number = httpServletRequest.getParameter("number");

        if (name.length() > 0 && email.length() > 0 && password.length() > 0
                && surname.length() > 0 && passport.length() > 0
                && address.length() > 0) {
            //create new customer
            if (tariff.length() > 0 && number.length() > 0) {
                customerService.saveCustomer(name, surname, birthdate, email,
                        password, address, passport);
                Customer saved = customerService.findByPassport(passport);
                Contract contract = new Contract(saved,
                        tariffService.findById(Integer.parseInt(tariff)));
                contract.setNumber(Integer.parseInt(number));
                contractService.newContract(contract);
            } else {
                //update old
                customerService.saveCustomer(name, surname, birthdate, email,
                        password, address, passport);
            }
            return getCustomersContracts(model, httpServletRequest);
        } else {
            model.addAttribute("name", name);
            model.addAttribute("email", email);
            model.addAttribute("surname", surname);
            model.addAttribute("birthdate", birthdate);
            model.addAttribute("passport", passport);
            model.addAttribute("address", address);
            model.addAttribute("password", password);
            model.addAttribute("message",
                    "Registration Failed!\nFill all fields properly.");
            return "employee/editCustomer";
        }
    }

    @RequestMapping("/removeCustomers")
    public final String removeCustomers(final Model model,
            final HttpServletRequest httpServletRequest) {
        Set<Customer> remove
                = getCustomers("remove", httpServletRequest);
        for (Customer c : remove) {
            customerService.deleteCustomer(c);
        }
        return getAllCustomers(model);
    }

    @RequestMapping("/option")
    public final String newOptionPage(final Model model,
            @RequestParam(required = false) String message) {
        Option option = new Option();
        option.setName("New");
        model.addAttribute("option", option);
        model.addAttribute("message", message);
        model.addAttribute("availableOptions", optionService.getAllOptions());
        return "employee/option";
    }

    @RequestMapping("/option/{id}")
    public final String optionPage(
            @PathVariable("id") int id, final Model model) {
        Option option = optionService.findByID(id);
        model.addAttribute("option", option);
        model.addAttribute("relatedOptions", option.getOptionsForRelId2());
        model.addAttribute("incompatibleOptions",
                option.getOptionsForIncompId2());
        Set<Option> availableOptions = optionService.getAllOptions();
        availableOptions.remove(option);
        for (Option o : option.getOptionsForRelId2()) {
            availableOptions.remove(o);
        }
        for (Option o : option.getOptionsForIncompId2()) {
            availableOptions.remove(o);
        }
        model.addAttribute("availableOptions", availableOptions);
        return "employee/option";
    }

    @RequestMapping("/saveOption")
    public final String saveOption(final Model model,
            final HttpServletRequest httpServletRequest) {
        Option option = new Option(
                httpServletRequest.getParameter("name"),
                Float.parseFloat(httpServletRequest.getParameter("rate")),
                Float.parseFloat(httpServletRequest.getParameter("price")));
        optionService.createOption(option);
        Set<Option> related
                = getOptions("related", httpServletRequest);
        for (Option o : related) {
            optionService.setRelatedness(option.getName(), o.getName());
        }
        Set<Option> incompatible
                = getOptions("incompatible", httpServletRequest);
        for (Option o : incompatible) {
            optionService.setIncompatibility(option.getName(), o.getName());
        }
        return getAllOptions(model);
    }

    @RequestMapping("/saveOption/{id}")
    public final String saveOption(@PathVariable("id") int id,
            final Model model, final HttpServletRequest httpServletRequest) {
        Option option = optionService.findByID(id);
        option.setName(httpServletRequest.getParameter("name"));
        option.setRate(
                Float.parseFloat(httpServletRequest.getParameter("rate")));
        option.setPrice(
                Float.parseFloat(httpServletRequest.getParameter("price")));
        optionService.saveOption(option);
        optionService.independentOption(option);
        Set<Option> related
                = getOptions("related", httpServletRequest);
        for (Option o : related) {
            optionService.setRelatedness(option.getName(), o.getName());
        }
        Set<Option> incompatible
                = getOptions("incompatible", httpServletRequest);
        for (Option o : incompatible) {
            optionService.setIncompatibility(option.getName(), o.getName());
        }
        return getAllOptions(model);
    }

    @RequestMapping("/removeOptions")
    public final String removeOptions(final Model model,
            final HttpServletRequest httpServletRequest) {
        Set<Option> remove
                = getOptions("remove", httpServletRequest);
        for (Option o : remove) {
            optionService.deleteOption(o);
        }
        return getAllOptions(model);
    }

    @RequestMapping("/tariff")
    public final String getTariffPage(final Model model,
            @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        model.addAttribute("options", optionService.getAllOptions());
        return "employee/tariff";
    }

    @RequestMapping(value = "tariff/{id}")
    public final String getTariffEditPage(
            @PathVariable("id") int id, Model model) {
        Tariff tariff = tariffService.findById(id);
        model.addAttribute("tariff", tariffService.findById(id));

        return "employee/tariff";
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
            return "redirect:tariff";
        } catch (NullPointerException npe) {
            model.addAttribute("message", "All fields are necessary.");
            return "redirect:tariff";
        }
    }

    @RequestMapping("newContract")
    public final String newContract(final Model model,
            final HttpServletRequest httpServletRequest) {
        Customer customer = customerService.
                findByPassport(httpServletRequest.getParameter("passport"));
        model.addAttribute("customer", customer);
        model.addAttribute("availableTariffs", tariffService.getAvailableTariffs());

//todo add page with new contract 


        return "employee/customersTariff";
    }

    @RequestMapping(value = "contractTariff/{number}")
    public final String getTariffChangingPage(
            @PathVariable("number") int number, final Model model) {
        Contract contract = contractService.findByNumber(number);
        model.addAttribute("customer", contract.getCustomer());
        model.addAttribute("contract", contract);
        model.addAttribute("availableTariffs", tariffService.getAvailableTariffs());
        return "employee/customersTariff";
    }

    @RequestMapping(value = "changeTariff")
    public final String changeTariff(final Model model,
            final HttpServletRequest httpServletRequest) {
        Contract contract = contractService.
                findByNumber(Integer.parseInt(httpServletRequest.
                                getParameter("number")));
        Tariff newTariff = tariffService.
                findById(Integer.parseInt(httpServletRequest.
                                getParameter("tariff")));
        contract.setTariff(newTariff);
        contractService.save(contract);
        model.addAttribute("contracts", contractService.getAllContracts());
        return "employee/allContracts";
    }

    @RequestMapping(value = "contractOptions/{number}")
    public final String getContractOptionsPage(
            @PathVariable("number") int number, Model model) {
        Contract contract = contractService.findByNumber(number);
        //set current contract
        model.addAttribute("contract", contract);
        //available options this contract's tariff excluding already added.
        Set<Option> availableOptions
                = tariffService.getAvailableOptions(contract.getTariff());
        for (Option o : contract.getOptions()) {
            availableOptions.remove(o);
        }
        model.addAttribute("availableOptions", availableOptions);
        return "employee/customersOptions";
    }

    @RequestMapping(value = "changeContractOptions")
    public final String changeContractOptions(final Model model,
            final HttpServletRequest httpServletRequest) {
        Contract contract = contractService.
                findByNumber(Integer.parseInt(httpServletRequest.
                                getParameter("number")));
        Set<Option> add = getOptions("addOption", httpServletRequest);
        Set<Option> rem = getOptions("remOption", httpServletRequest);
        Set<Option> activeOptions = contract.getOptions();
        for (Option o : add) {
            activeOptions.add(o);
        }
        for (Option o : rem) {
            activeOptions.remove(o);
        }
        contract.setOptions(activeOptions);
        contractService.save(contract);

        Person customer = contract.getCustomer().getPerson();
        Set<Contract> contracts = customerService.
                getAllContracts(contract.getCustomer());
        model.addAttribute("contracts", contracts);
        model.addAttribute("owners", "of " + customer.getName()
                + " " + customer.getSurname());
        return "employee/allContracts";
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

    @RequestMapping(value = "lockCustomer/{passport}")
    public final String lockCustomer(
            @PathVariable("passport") final String passport,
            final Model model) {
        Customer customer = customerService.findByPassport(passport);
        if (customerService.isLocked(customer)) {
            customerService.unlockCustomer(customer);
        } else {
            customerService.lockCustomer(customer);
        }
        return getAllCustomers(model);
    }
}
