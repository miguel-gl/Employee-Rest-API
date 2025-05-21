package com.employees.api.infrastructure.handler;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: ErrorResponse is the standard of my responses.
 * Date: 2025-05-21
 * Version: 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String mensaje;
    private List<String> detalles;
}
