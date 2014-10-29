/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tsystems.ecare.persistence.dao.implementations;

import ru.tsystems.ecare.persistence.dao.interfaces.EmployeeDAO;
import java.util.List;
import org.hibernate.Query;
import ru.tsystems.ecare.dto.EmployeeDTO;
import ru.tsystems.ecare.persistence.entities.Employee;

public class EmployeeDAOImpl
        extends GenericDAOImpl<EmployeeDTO, Employee> implements EmployeeDAO {

}
