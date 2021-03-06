package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 15.10.2014 12:12:11 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "ECareDB")
public class Employee implements java.io.Serializable {

	private Integer personId;
	private Person person;

	public Employee() {
	}

	public Employee(Person person) {
		this.person = person;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "person_id", unique = true, nullable = false)
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
