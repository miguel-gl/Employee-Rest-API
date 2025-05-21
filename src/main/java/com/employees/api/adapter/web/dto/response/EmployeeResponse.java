package com.employees.api.adapter.web.dto.response;


/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: Record for client response.
 * Date: 2025-05-21
 * Version: 1.0
 */

public record  EmployeeResponse (
    int id,
    String fullName,
    int age,
    String date,
    String position){
}
