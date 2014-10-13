package ru.tsystems.ecare.persistence.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.tsystems.ecare.persistence.entities.Role;

public class RoleDAOImplTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindById() {
		// given
		// add entry to DB
		
		
		// when
		// find added entry by id
		
		// then
		// assert that found and original entries are equal
		//TODO assertEquals(expected, actual);
		fail("Not yet implemented");

	}
	
	@Test
	public void testFinfByName() {
		Role r1 = new Role("customer");
		
		RoleDAO rd = new RoleDAOImpl();
		Role r2 = rd.findByName("customer");
		assertEquals(r1,r2);
	}

}
