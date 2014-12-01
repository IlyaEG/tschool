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
import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class TariffServiceImplTest extends AbstractJUnit4SpringContextTests {

    TariffServiceImpl tariffService;
    ContractDAOImpl contractDAO;
    OptionDAOImpl optionDAO;
    TariffDAOImpl tariffDAO;
    Tariff tariff;
    Set<Tariff> tariffs;

    @Before
    public final void setUp() {

        tariffService = new TariffServiceImpl();

        contractDAO = mock(ContractDAOImpl.class);
        tariffService.setContractDAO(contractDAO);

        optionDAO = mock(OptionDAOImpl.class);
        tariffService.setOptionDAO(optionDAO);

        //setup tariffDAO mock
        tariffDAO = mock(TariffDAOImpl.class);
        tariffService.setTariffDAO(tariffDAO);

        tariff = new Tariff("test-tariff", 0f);
        tariffs = new HashSet<>();
        //all tariffs
        when(tariffDAO.all()).thenReturn(tariffs);
        //add tariff
        doAnswer(new TariffAnswer("add")).when(tariffDAO).add(tariff);
        //delete tariff
        doAnswer(new TariffAnswer("remove")).when(tariffDAO).remove(tariff);

    }

    @Test
    public void testGetAvailableTariffs() {

        tariffs.add(tariff);

        assert (tariffService.getAvailableTariffs().contains(tariff));
    }

    @Test
    public void testCreateTariff() {

        tariffService.createTariff(tariff);

        assert (tariffService.getAvailableTariffs().contains(tariff));

    }

    @Test
    public void testDeleteTariff() {
        tariffService.deleteTariff(tariff);
        assert (!tariffService.getAvailableTariffs().contains(tariff));
    }

    @Test
    public void testChangeTariff() {
//        tariffService.
        assert (true);
    }

    class TariffAnswer implements Answer<Object> {

        private final String action;

        public TariffAnswer(String action) {
            this.action = action;
        }

        @Override
        public Object answer(final InvocationOnMock invocation)
                throws Throwable {
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

            Object[] args = invocation.getArguments();
            return "called with arguments: " + Arrays.toString(args);

        }

    }
}
