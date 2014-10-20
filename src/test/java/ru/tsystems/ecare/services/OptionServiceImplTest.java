package ru.tsystems.ecare.services;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import ru.tsystems.ecare.persistence.entities.Option;

public class OptionServiceImplTest {

	private static OptionService optionService = new OptionServiceImpl();
/*
	@Test
	public void testCreateGetDeleteOption() {
		Option option = null;
		// create option
		try {
			option = new Option("new option", 23.4f, 0);
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
			deleteOption(option);
			e.printStackTrace();
			fail("fail to get option");
		} finally {
			// delete option
			deleteOption(option);
		}
	}

	@Test
	public void testFindByName() {
		Option option = null;
		// create option
		try {
			option = new Option("new option", 23.4f, 0);
			optionService.createOption(option);
		} catch (Exception e) {
			e.printStackTrace();
			deleteOption(option);
			fail("fail to create option");
		}
		assertNotNull(option);
		// get all options
		try {
			Option optionsFromDB = optionService.findByName(option.getName());
			assertEquals(option, optionsFromDB);
		} catch (Exception e) {
			e.printStackTrace();
			deleteOption(option);
			fail("fail to get option");
		}
		// delete option
		deleteOption(option);
	}

	@Test
	public void testDeleteFindByName() {
		// create option
		try {
			optionService.createOption(new Option("test1", 23.4f, 0));
			optionService.createOption(new Option("test2", 13.4f, 0));
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create option");
		}
		deleteOption(optionService.findByName("test1"));
		deleteOption(optionService.findByName("test2"));
	}

	@Test
	public void testSetIncompatibility() {
		optionService.setIncompatibility("test3", "test4");

	}
	
	@Test
	public void testSetRelatedness() {
		optionService.setRelatedness("test3", "test4");

	}

	@Test
	public void testGetIncompatible() {
		Set<Option> incomp = optionService.getIncompatibile("inc1");
		for (Option o : incomp) {
			System.out.println("=================\n\n\n" + o.getName() + "\n\n============\n\n");
		}
	}
	
	@Test
	public void testGetRelated() {
		Set<Option> incomp = optionService.getRelated("inc1");
		for (Option o : incomp) {
			System.out.println("=================\n\n\n" + o.getName() + "\n\n============\n\n");
		}
	}
	

	private void deleteOption(Option option) {
		try {
			optionService.deleteOption(option);
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to delete option: " + option.getName());
		}
	}
//*/
}
