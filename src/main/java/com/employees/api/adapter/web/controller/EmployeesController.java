package com.employees.api.adapter.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.api.adapter.web.dto.request.EmployeeRequest;
import com.employees.api.adapter.web.dto.response.EmployeeResponse;
import com.employees.api.application.port.input.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: Principal Controller.
 * Date: 2025-05-21
 * Version: 1.0
 */

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@Validated
public class EmployeesController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
    private final EmployeeService employeeService;

    @Operation(summary = "Get All Employees in BD")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> listarTodos() {
        logger.info("Get all Request In Controller");
        List<EmployeeResponse> employees = employeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @Operation(summary = "Delete an Employee spesific whit a id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        logger.info("Delete Request In Controller");
        employeeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Modify an Employee in BD whit id")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeRequest employee) {
        logger.info("Modify Request In Controller");
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create one or many Employees whit a List")
    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody @Valid List<EmployeeRequest> employees) {
        logger.info("Create Request In Controller");
        employeeService.createEmployees(employees);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
