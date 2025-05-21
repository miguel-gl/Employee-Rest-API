package com.employees.api.infrastructure.handler;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employees.api.domain.exception.EmpleadoNotFoundException;

import java.util.List;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: GlobalExceptionHandler for managment Exceptions in the service.
 * Date: 2025-05-21
 * Version: 1.0
 */


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> details = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(new ErrorResponse("Solicitud inválida", details));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> details = ex.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .toList();

        return ResponseEntity.badRequest().body(new ErrorResponse("Violación de restricciones", details));
    }
    
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<String> handleEmpleadoNoEncontrado(EmpleadoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
