package ru.tsystems.ecare.persistence.entities;

// default package
// Generated 09.10.2014 13:21:52 by Hibernate Tools 4.3.1

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private Integer id;
	private Role role;
	private String name;
	private String surname;
	private String password;
	private String email;
	private String adress;
	private Employee employee;
	private Customer customer;

	public Person() {
	}

	public Person(Role role, String name, String surname, String password) {
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public Person(Role role, String name, String surname, String password,
			String email, String adress, Employee employee, Customer customer) {
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.employee = employee;
		this.customer = customer;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
