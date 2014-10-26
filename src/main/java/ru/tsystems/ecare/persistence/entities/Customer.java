package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 15.10.2014 12:12:11 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Customer entity
 */
@NamedQueries({
	@NamedQuery(
	name = "findCustomerByPassport",
	query = "from Customer c where c.customerPassport = :passport"
	)
})
@Entity
@Table(name = "customer", catalog = "ECareDB", uniqueConstraints = @UniqueConstraint(columnNames = "customer_passport"))
public class Customer implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6118168012820426567L;
	private Integer personId;
	private Person person;
	private String customerPassport;
	private Boolean locked;
	private Set<Contract> contracts = new HashSet<>(0);

	public Customer() {
	}

	public Customer(Person person, String customerPassport) {
		this.person = person;
		this.customerPassport = customerPassport;
	}

	public Customer(Person person, String customerPassport,
			Set<Contract> contracts) {
		this.person = person;
		this.customerPassport = customerPassport;
		this.contracts = contracts;
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

	@Column(name = "customer_passport", unique = true, nullable = false, length = 45)
	public String getCustomerPassport() {
		return this.customerPassport;
	}

	public void setCustomerPassport(String customerPassport) {
		this.customerPassport = customerPassport;
	}

	@Column(name = "locked")
	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	public Set<Contract> getContracts() {
		return this.contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

}
