package ru.tsystems.ecare.controller.employee;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.ContractService;
import ru.tsystems.ecare.services.CustomerService;
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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

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

    
}
