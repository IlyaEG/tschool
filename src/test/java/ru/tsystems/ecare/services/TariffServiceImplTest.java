package ru.tsystems.ecare.services;

import com.mysql.jdbc.Connection;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.JdbcTestUtils;
import ru.tsystems.ecare.persistence.dao.impl.ContractDAOImpl;
import ru.tsystems.ecare.persistence.dao.impl.OptionDAOImpl;
import ru.tsystems.ecare.persistence.dao.impl.TariffDAOImpl;

import ru.tsystems.ecare.persistence.entities.Tariff;
import ru.tsystems.ecare.services.impl.TariffServiceImpl;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class TariffServiceImplTest extends AbstractJUnit4SpringContextTests {

    TariffServiceImpl tariffService;

    @Before
    public void setUp() {
        tariffService = new TariffServiceImpl();
        tariffService.setContractDAO(mock(ContractDAOImpl.class));
        tariffService.setOptionDAO(mock(OptionDAOImpl.class));
        tariffService.setTariffDAO(mock(TariffDAOImpl.class));
    }

    @Test
    public void testCreateTariff() {

        Tariff tariff = new Tariff("test-tariff", -3.0f);

        tariffService.createTariff(tariff);
    }
//
//    @Test
//    public void testTasksForEmployees() {
//        Employee steve = employeeDao.find(1L);
//        Employee bill = employeeDao.find(2L);
//
//        assertEquals(2, timesheetService.tasksForEmployee(steve).size());
//        assertEquals(1, timesheetService.tasksForEmployee(bill).size());
//    }
//
//    @Test
//    public void testTasksForManagers() {
//        Manager eric = managerDao.find(1L);
//        assertEquals(1, timesheetService.tasksForManager(eric).size());
//    }
}
