package com.employees.api.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employees.api.adapter.web.dto.request.EmployeeRequest;
import com.employees.api.adapter.web.dto.response.EmployeeResponse;
import com.employees.api.application.port.input.EmployeeService;
import com.employees.api.application.port.output.EmployeeRepository;
import com.employees.api.domain.exception.EmployeeNotFoundException;
import com.employees.api.domain.model.Employee;
import com.employees.api.infrastructure.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeServiceImpl Implements methos of EmployeeService.
 * Date: 2025-05-21
 * Version: 1.0
 */

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return mapper.fromDomainListToResponseList(employees);
    }

    @Override
    public void createEmployees(List<EmployeeRequest> requests) {
        List<Employee> domain = mapper.fromRequestListToDomainList(requests);
        employeeRepository.saveAll(domain);
    }

    @Override
    public void updateEmployee(Long id, EmployeeRequest employee) {
         if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee " + id + " Not found.");
        }
        Employee domain = mapper.fromRequestToDomain(employee);
        domain.setId(id);
        employeeRepository.save(domain);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeeRepository.deleteById(id);
    }
    
}
