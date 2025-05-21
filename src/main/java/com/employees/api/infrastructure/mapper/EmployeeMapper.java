package com.employees.api.infrastructure.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.employees.api.adapter.web.dto.request.EmployeeRequest;
import com.employees.api.adapter.web.dto.response.EmployeeResponse;
import com.employees.api.domain.model.Employee;
import com.employees.api.infrastructure.repository.EmployeeEntity;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeMapper mapper for managments yhe DTO´S.
 * Date: 2025-05-21
 * Version: 1.0
 */

@Mapper(componentModel = "spring")
public interface  EmployeeMapper {

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Employee fromRequestToDomain(EmployeeRequest request);

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "fullName", expression = "java(concatFullName(employee))")
    EmployeeResponse fromDomainToResponse(Employee employee);

    EmployeeEntity fromDomainToEntity(Employee employee);

    Employee fromEntityToDomain(EmployeeEntity entity);

    List<Employee> fromEntityListToDomainList(List<EmployeeEntity> entities);

    List<EmployeeResponse> fromDomainListToResponseList(List<Employee> employees);

    List<Employee> fromRequestListToDomainList(List<EmployeeRequest> requests);

    List<EmployeeEntity> fromDomainListToEntityList(List<Employee> employees);

    default String concatFullName(Employee employee) {
        return String.join(" ",
            employee.getFirstName(),
            employee.getSecondName(),
            employee.getFirstLastName(),
            employee.getSecondLastName()
        ).trim().replaceAll(" +", " ");
    }
}
