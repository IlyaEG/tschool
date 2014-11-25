package ru.tsystems.ecare.controller.employee;

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
        } catch (Exception e) {
            model.addAttribute("message",
                    "Please input right contract number!");
            return "employee/searchCustomer";
        }

    }

}
