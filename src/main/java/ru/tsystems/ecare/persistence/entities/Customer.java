package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 15.10.2014 12:12:11 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
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
    ),
    @NamedQuery(
            name = "lockStatus",
            query = "select locked from Customer c where c.customerPassport = :passport"
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

    public Customer(Person person, String customerPassport, boolean locked) {
        this.person = person;
        this.customerPassport = customerPassport;
        this.locked = locked;
    }

    public Customer(Person person, String customerPassport, boolean locked,
            Set<Contract> contracts) {
        this.person = person;
        this.customerPassport = customerPassport;
        this.locked = locked;
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

    @Column(name = "locked", nullable = false)
    public boolean getLocked() {
        return this.locked;
    }

    public void setLocked(final boolean locked) {
        this.locked = locked;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    public Set<Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.personId);
        hash = 89 * hash + Objects.hashCode(this.customerPassport);
        return hash;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.personId, other.personId)) {
            return false;
        }
        return Objects.equals(this.customerPassport, other.customerPassport);
    }

}
