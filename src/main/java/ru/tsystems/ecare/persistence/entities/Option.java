package ru.tsystems.ecare.persistence.entities;
// default package
// Generated 15.10.2014 12:12:11 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Option entity
 */
@NamedQueries({
    @NamedQuery(
            name = "findOptionByName",
            query = "from Option o where o.name = :optionName"
    )
})
@Entity
@Table(name = "option", catalog = "ECareDB", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Option implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2859805760076315787L;
    private Integer id;
    private String name;
    private float rate;
    private float price;
    private Set<Option> optionsForIncompId2 = new HashSet<>(0);
    private Set<Option> optionsForRelId2 = new HashSet<>(0);
    private Set<Option> optionsForIncompId1 = new HashSet<>(0);
    private Set<Option> optionsForRelId1 = new HashSet<>(0);
    private Set<Tariff> tariffs = new HashSet<>(0);
    private Set<Contract> contracts = new HashSet<>(0);

    public Option() {
    }

    public Option(String name, float rate, float price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public Option(String name, float rate, float price,
            Set<Option> optionsForIncompId2, Set<Option> optionsForRelId2,
            Set<Option> optionsForIncompId1, Set<Option> optionsForRelId1,
            Set<Tariff> tariffs, Set<Contract> contracts) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.optionsForIncompId2 = optionsForIncompId2;
        this.optionsForRelId2 = optionsForRelId2;
        this.optionsForIncompId1 = optionsForIncompId1;
        this.optionsForRelId1 = optionsForRelId1;
        this.tariffs = tariffs;
        this.contracts = contracts;
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

    @Column(name = "name", unique = true, nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "rate", nullable = false, precision = 12, scale = 0)
    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Column(name = "price", nullable = false, precision = 12, scale = 0)
    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "incompatible_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "incomp_id_1", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "incomp_id_2", nullable = false, updatable = false)})
    public Set<Option> getOptionsForIncompId2() {
        return this.optionsForIncompId2;
    }

    public void setOptionsForIncompId2(Set<Option> optionsForIncompId2) {
        this.optionsForIncompId2 = optionsForIncompId2;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "related_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "rel_id_1", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "rel_id_2", nullable = false, updatable = false)})
    public Set<Option> getOptionsForRelId2() {
        return this.optionsForRelId2;
    }

    public void setOptionsForRelId2(Set<Option> optionsForRelId2) {
        this.optionsForRelId2 = optionsForRelId2;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "incompatible_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "incomp_id_2", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "incomp_id_1", nullable = false, updatable = false)})
    public Set<Option> getOptionsForIncompId1() {
        return this.optionsForIncompId1;
    }

    public void setOptionsForIncompId1(Set<Option> optionsForIncompId1) {
        this.optionsForIncompId1 = optionsForIncompId1;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "related_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "rel_id_2", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "rel_id_1", nullable = false, updatable = false)})
    public Set<Option> getOptionsForRelId1() {
        return this.optionsForRelId1;
    }

    public void setOptionsForRelId1(Set<Option> optionsForRelId1) {
        this.optionsForRelId1 = optionsForRelId1;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tariff_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "option_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "tariff_id", nullable = false, updatable = false)})
    public Set<Tariff> getTariffs() {
        return this.tariffs;
    }

    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "contract_option", catalog = "ECareDB", joinColumns = {
        @JoinColumn(name = "option_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "contract_number", nullable = false, updatable = false)})
    public Set<Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Option other = (Option) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
