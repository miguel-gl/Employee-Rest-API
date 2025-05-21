package com.employees.api.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import com.employees.api.adapter.web.dto.request.EmployeeRequest;
import com.employees.api.adapter.web.dto.response.EmployeeResponse;
import com.employees.api.application.port.output.EmployeeRepository;
import com.employees.api.domain.exception.EmpleadoNotFoundException;
import com.employees.api.domain.model.Employee;
import com.employees.api.infrastructure.mapper.EmployeeMapper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeServiceImpl Tests.
 * Date: 2025-05-21
 * Version: 1.0
 */

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

@Test
void testGetEmployees_returnsList() {
    List<Employee> domainList = List.of(new Employee());

    List<EmployeeResponse> responseList = List.of(
        new EmployeeResponse(
            1,
            "Miguel Angel Gonzalez Lopez",
            30,
            "01-01-1994",
            "Desarrollador Backend"
        )
    );

    when(employeeRepository.findAll()).thenReturn(domainList);
    when(employeeMapper.fromDomainListToResponseList(domainList)).thenReturn(responseList);

    List<EmployeeResponse> result = employeeService.getEmployees();

    assertEquals(1, result.size());
    assertEquals("Miguel Angel Gonzalez Lopez", result.get(0).fullName());
    verify(employeeRepository).findAll();
    verify(employeeMapper).fromDomainListToResponseList(domainList);
}

    @Test
    void testCreateEmployees_savesList() {
        List<EmployeeRequest> requestList = List.of(new EmployeeRequest());
        List<Employee> domainList = List.of(new Employee());

        when(employeeMapper.fromRequestListToDomainList(requestList)).thenReturn(domainList);

        employeeService.createEmployees(requestList);

        verify(employeeMapper).fromRequestListToDomainList(requestList);
        verify(employeeRepository).saveAll(domainList);
    }

    @Test
    void testUpdateEmployee_successfulUpdate() {
        Long id = 1L;
        EmployeeRequest request = new EmployeeRequest();
        Employee domain = new Employee();
        domain.setId(id);

        when(employeeRepository.existsById(id)).thenReturn(true);
        when(employeeMapper.fromRequestToDomain(request)).thenReturn(domain);

        employeeService.updateEmployee(id, request);

        verify(employeeRepository).save(domain);
    }

    @Test
    void testUpdateEmployee_throwsNotFound() {
        Long id = 999L;
        EmployeeRequest request = new EmployeeRequest();

        when(employeeRepository.existsById(id)).thenReturn(false);

        assertThrows(EmpleadoNotFoundException.class, () -> employeeService.updateEmployee(id, request));
        verify(employeeRepository, never()).save(any());
    }

    @Test
    void testDeleteEmployee_callsRepository() {
        Long id = 5L;

        employeeService.deleteEmploye(id);

        verify(employeeRepository).deleteById(id);
    }
}
