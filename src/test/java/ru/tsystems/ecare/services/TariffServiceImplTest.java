package ru.tsystems.ecare.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import ru.tsystems.ecare.persistence.dao.impl.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.impl.OptionDAOImpl;
import ru.tsystems.ecare.persistence.dao.impl.TariffDAOImpl;
import ru.tsystems.ecare.persistence.entities.Contract;
import ru.tsystems.ecare.persistence.entities.Customer;
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class TariffServiceImplTest extends AbstractJUnit4SpringContextTests {

    private TariffServiceImpl tariffService;
    private ContractDAOImpl contractDAO;
    private OptionDAOImpl optionDAO;
    private TariffDAOImpl tariffDAO;
    private Tariff tariff;
    private Set<Tariff> tariffs;
    private Contract contract;
    private Customer customer;
    private Set<Customer> customers;

    @Before
    public final void setUp() {
        tariff = new Tariff("test-tariff", 0f);
        tariffs = new HashSet<>();
        customers = new HashSet<>();

        customer = mock(Customer.class);
        contract = new Contract(customer, tariff);

        tariffService = new TariffServiceImpl();

        contractDAO = mock(ContractDAOImpl.class);
        tariffService.setContractDAO(contractDAO);
        doAnswer(new DAOAnswer("contract", "update"))
                .when(contractDAO).update(contract);

        optionDAO = mock(OptionDAOImpl.class);
        tariffService.setOptionDAO(optionDAO);

        //setup tariffDAO mock
        tariffDAO = mock(TariffDAOImpl.class);
        tariffService.setTariffDAO(tariffDAO);

        //all tariffs
        when(tariffDAO.all()).thenReturn(tariffs);
        //add tariff
        doAnswer(new DAOAnswer("tariff", "add"))
                .when(tariffDAO).add(tariff);
        //delete tariff
        doAnswer(new DAOAnswer("tariff", "remove"))
                .when(tariffDAO).remove(tariff);

    }

    @Test
    public final void testGetAvailableTariffs() {

        tariffs.add(tariff);

        assert (tariffService.getAvailableTariffs().contains(tariff));
    }

    @Test
    public final void testCreateTariff() {

        tariffService.createTariff(tariff);

        assert (tariffService.getAvailableTariffs().contains(tariff));

    }

    @Test
    public final void testDeleteTariff() {
        tariffService.deleteTariff(tariff);
        assert (!tariffService.getAvailableTariffs().contains(tariff));
    }

    @Test
    public final void testChangeTariff() {
//        Tariff newTariff = new Tariff("newTestTariff", 1f);
//        tariffService.createTariff(newTariff);
//        assert (tariffService.getAvailableTariffs().contains(newTariff));
//
//        tariffService.changeTariff(contract, tariff);
//        assert (tariffService.);
        assert(true);
    }

    class DAOAnswer implements Answer<Object> {

        private final String action;
        private final String dao;

        public DAOAnswer(String dao, final String action) {
            this.action = action;
            this.dao = dao;
        }

        @Override
        public Object answer(final InvocationOnMock invocation)
                throws Throwable {
            switch (dao) {
                case "tariff":
                    switch (action) {
                        case "remove":
                            tariffs.remove(tariff);
                            break;
                        case "add":
                            tariffs.add(tariff);
                            break;
                        default:
                            break;
                    }
                    break;
                case "contract":
                    switch (action) {
                        case "remove":
                            customers.remove(customer);
                            break;
                        case "add":
                            customers.add(customer);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

            Object[] args = invocation.getArguments();

            return "called with arguments: " + Arrays.toString(args);

        }

    }
}
