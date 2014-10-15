package ru.tsystems.ecare.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ru.tsystems.ecare.persistence.entities.Tariff;

public class TariffServiceImplTest {

	@Test
	public void testGetAvailableTariffs() {
		try {
			TariffService tariffService = new TariffServiceImpl();
			List<Tariff> tariffs = tariffService.getAvailableTariffs();
			for (Tariff t : tariffs) {
				System.out.println(t.getName() + t.getRate());
			}
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

}
