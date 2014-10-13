package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 13.10.2014 11:45:52 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "Role", catalog = "ECareDB", uniqueConstraints = @UniqueConstraint(columnNames = "Role"))
public class Role implements java.io.Serializable {

	/**
	 * generted serialVersionUID
	 */
	private static final long serialVersionUID = -2409466361960240999L;
	private Integer id;
	private String role;
	private Set<Person> persons = new HashSet<Person>(0);

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}

	public Role(String role, Set<Person> persons) {
		this.role = role;
		this.persons = persons;
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

	@Column(name = "Role", unique = true, nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
