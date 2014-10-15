package ru.tsystems.ecare.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ru.tsystems.ecare.persistence.entities.Option;

public class OptionServiceImplTest {

	@Test
	public void testCreateGetDeleteOption() {
		Option option = null;
		OptionService optionService = new OptionServiceImpl();
		// create option
		try {
			option = new Option("new option", 23.4f); 
			optionService.createOption(option);
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create option");
		}
		assertNotNull(option);
		// get all options
		try {
			List<Option> allOptions = optionService.getAllOptions();
			for (Option o : allOptions) {
				if (o.equals(option)) {
					assertEquals(option, o);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to get option");
		}
		//delete option
//		try {
//			optionService.deleteOption(option);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("fail to delete option");
//		}
	}

	@Test
	public void testSetIncompatibility() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRelatedness() {
		fail("Not yet implemented");
	}

}
