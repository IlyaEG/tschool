package ru.tsystems.ecare.persistence.entities;

// default package
// Generated 09.10.2014 13:21:52 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private Integer id;
	private String role;
	private Set persons = new HashSet(0);

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public Role(String role, Set persons) {
		this.role = role;
		this.persons = persons;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set getPersons() {
		return this.persons;
	}

	public void setPersons(Set persons) {
		this.persons = persons;
	}

}