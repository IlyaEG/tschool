package ru.tsystems.ecare.persistence.entities;

// default package
// Generated 09.10.2014 13:21:52 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Integer id;
	private Person person;
	private String customerPassport;
	private Set contracts = new HashSet(0);

	public Customer() {
	}

	public Customer(Person person, String customerPassport) {
		this.person = person;
		this.customerPassport = customerPassport;
	}

	public Customer(Person person, String customerPassport, Set contracts) {
		this.person = person;
		this.customerPassport = customerPassport;
		this.contracts = contracts;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCustomerPassport() {
		return this.customerPassport;
	}

	public void setCustomerPassport(String customerPassport) {
		this.customerPassport = customerPassport;
	}

	public Set getContracts() {
		return this.contracts;
	}

	public void setContracts(Set contracts) {
		this.contracts = contracts;
	}

}
