package com.employees.api.domain.exception;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmpleadoNotFoundException is a custom exception for managment nt found employee in updtatings .
 * Date: 2025-05-21
 * Version: 1.0
 */
public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
