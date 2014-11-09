/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tsystems.ecare.persistence.dao.EmployeeDAO;
import ru.tsystems.ecare.persistence.entities.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends HibernateDAO<Employee, Integer>
        implements EmployeeDAO {

}
