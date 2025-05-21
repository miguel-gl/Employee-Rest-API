package com.employees.api.infrastructure.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.employees.api.domain.exception.EmployeeNotFoundException;


import jakarta.validation.Path;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: Global Exception Class Tests.
 * Date: 2025-05-21
 * Version: 1.0
 */

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    void handleEmpleadoNotFound_returns404() {
        String mensaje = "Empleado con ID 99 no encontrado";
        EmployeeNotFoundException ex = new EmployeeNotFoundException(mensaje);

        ResponseEntity<String> response = handler.handleEmpleadoNoEncontrado(ex);

        assertEquals(404, response.getStatusCode().value());
        assertEquals(mensaje, response.getBody());
    }

    @Test
    void handleConstraintViolation_returns400() {
        // Simula una violación de restricción
        Path path = mock(Path.class);
        when(path.toString()).thenReturn("edad");

        ConstraintViolation<?> mockViolation = mock(ConstraintViolation.class);
        when(mockViolation.getPropertyPath()).thenReturn(path);
        when(mockViolation.getMessage()).thenReturn("debe ser mayor que 0");

        ConstraintViolationException ex = new ConstraintViolationException(Set.of(mockViolation));

        ResponseEntity<ErrorResponse> response = handler.handleConstraintViolation(ex);

        assertEquals(400, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Violación de restricciones", response.getBody().getMensaje());
        assertTrue(response.getBody().getDetalles().get(0).contains("edad"));
    }

    @Test
    void handleMethodArgumentNotValid_returns400() {
        // Simula un error de validación en un campo
        var bindingResult = mock(org.springframework.validation.BindingResult.class);
        FieldError error = new FieldError("obj", "nombre", "no debe estar vacío");
        when(bindingResult.getFieldErrors()).thenReturn(List.of(error));

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, bindingResult);

        ResponseEntity<ErrorResponse> response = handler.handleMethodArgumentNotValid(ex);

        assertEquals(400, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Solicitud inválida", response.getBody().getMensaje());
        assertTrue(response.getBody().getDetalles().get(0).contains("nombre"));
    }
}
