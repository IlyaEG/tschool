//package ru.tsystems.ecare.services;
//
//import com.mysql.jdbc.Connection;
//import ru.tsystems.ecare.services.impl.TariffServiceImpl;
//import static org.junit.Assert.*;
//
//import java.util.List;
//import java.util.Set;
//import org.junit.After;
//import org.junit.Before;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
//import org.springframework.jdbc.datasource.init.ScriptUtils;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.jdbc.JdbcTestUtils;
//
//import ru.tsystems.ecare.persistence.entities.Tariff;
//
//@ContextConfiguration(locations = "/persistence-beans.xml")
//public class TariffServiceImplTest extends AbstractJUnit4SpringContextTests {
//
//    @Autowired
//    private TariffService tariffService;
//
//// resources for accessing data during the testing
//    @Autowired
//    private Connection connection;
//
//    @Test
//    public void testCreateTariff() {
//        Tariff tariff = new Tariff("test-tariff", 3.0f);
//        tariffService.createTariff(tariff);
//        Set<Tariff> tariffs = tariffService.getAvailableTariffs();
//        if (!tariffs.contains(tariff)) {
//            fail();
//        }
//    }
////
////    @Test
////    public void testTasksForEmployees() {
////        Employee steve = employeeDao.find(1L);
////        Employee bill = employeeDao.find(2L);
////
////        assertEquals(2, timesheetService.tasksForEmployee(steve).size());
////        assertEquals(1, timesheetService.tasksForEmployee(bill).size());
////    }
////
////    @Test
////    public void testTasksForManagers() {
////        Manager eric = managerDao.find(1L);
////        assertEquals(1, timesheetService.tasksForManager(eric).size());
////    }
//}
