package com.employees.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: JpaEmployeeRepository whit low coupling for clean architecture.
 * Date: 2025-05-21
 * Version: 1.0
 */
public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
