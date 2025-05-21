package com.employees.api.infrastructure.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.employees.api.application.port.output.EmployeeRepository;
import com.employees.api.domain.model.Employee;
import com.employees.api.infrastructure.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeRepositoryImpl implements EmployeeRepository.
 * Date: 2025-05-21
 * Version: 1.0
 */


@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JpaEmployeeRepository jpaRepository;
    private final EmployeeMapper mapper;

   @Override
    public List<Employee> findAll() {
        return mapper.fromEntityListToDomainList(jpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        jpaRepository.save(mapper.fromDomainToEntity(employee));
    }

    @Override
    public void saveAll(List<Employee> employees) {
        List<EmployeeEntity> entities = mapper.fromDomainListToEntityList(employees);
        jpaRepository.saveAll(entities);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
