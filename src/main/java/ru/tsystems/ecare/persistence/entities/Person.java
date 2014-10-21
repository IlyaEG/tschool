package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 15.10.2014 12:12:11 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@NamedQueries({
	@NamedQuery(
	name = "allPersons",
	query = "from Person p"
	),
	@NamedQuery(
	name = "PersonRole",
	query = "select role from Person p where p.email = :userEmail"
	),
	@NamedQuery(
	name = "PersonByEmail&Password",
	query = "from Person p where where p.email = :userEmail and p.password = :userPassword")
})
@Entity
@Table(name = "person", catalog = "ECareDB")
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false, length = 100)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "adress", length = 200)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
