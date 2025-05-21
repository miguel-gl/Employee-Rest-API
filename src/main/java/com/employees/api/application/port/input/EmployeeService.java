package com.employees.api.application.port.input;

import java.util.List;

import com.employees.api.adapter.web.dto.request.EmployeeRequest;
import com.employees.api.adapter.web.dto.response.EmployeeResponse;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeService Abstraccion of the methods to admin employees.
 * Date: 2025-05-21
 * Version: 1.0
 */

public interface EmployeeService {
    List<EmployeeResponse> getEmployees();
    void createEmployees(List<EmployeeRequest> requests);
    void updateEmployee(Long id, EmployeeRequest employee);
    void deleteEmploye(Long id);
}
