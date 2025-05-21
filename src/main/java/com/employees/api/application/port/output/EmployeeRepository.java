package com.employees.api.application.port.output;

import java.util.List;

import com.employees.api.domain.model.Employee;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeRepository Abstraccion of the methods to admin employees.
 * Date: 2025-05-21
 * Version: 1.0
 */

public interface EmployeeRepository {
    List<Employee> findAll();
    void deleteById(Long id);
    void save(Employee employeemployee);
    void saveAll(List<Employee> employee);
    boolean existsById(Long id);
}
