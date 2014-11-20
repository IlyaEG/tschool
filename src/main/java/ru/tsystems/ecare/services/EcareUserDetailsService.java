/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.ecare.persistence.dao.PersonDAO;
import ru.tsystems.ecare.persistence.entities.Person;

/**
 *
 * @author ilya
 *
 * A custom {@link UserDetailsService} where user information is retrieved from
 * a JPA repository
 */
@Service
@Transactional(readOnly = true)
public class EcareUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonDAO personDAO;

    /**
     * Returns a populated {@link UserDetails} object. The userEmail is first
     * retrieved from the database and then mapped to a {@link UserDetails}
     * object.
     *
     * @param userEmail
     * @return {@link User}
     * @throws UsernameNotFoundException
     */
    @Override
    public final UserDetails loadUserByUsername(final String userEmail)
            throws UsernameNotFoundException {
        Person domainUser = personDAO.findByEmail(userEmail);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        User u = new User(
                domainUser.getEmail(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getName()));

        return u;
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a role name.
     *
     * @param role the role name
     * @return a collection of {@link GrantedAuthority
     */
    public final Collection<? extends GrantedAuthority>
            getAuthorities(final String role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a role names to an equivalent list of roles.
     *
     * @param role the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public final List<String> getRoles(final String role) {
        List<String> roles = new ArrayList<>();

        if (role.equalsIgnoreCase("employee")) {
            roles.add("ROLE_USER");
            roles.add("ROLE_EMPLOYEE");

        } else if (role.equalsIgnoreCase("customer")) {
            roles.add("ROLE_USER");
            roles.add("ROLE_CUSTOMER");
        }

        return roles;
    }

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects.
     *
     * @param roles {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority>
            getGrantedAuthorities(final List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
