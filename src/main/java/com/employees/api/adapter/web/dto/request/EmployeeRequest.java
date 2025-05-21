package com.employees.api.adapter.web.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeRequest like DTO.
 * Date: 2025-05-21
 * Version: 1.0
 */

@Data
public class EmployeeRequest {
    @NotBlank
    private String firstName;
    private String secondName;
    @NotBlank
    private String firstLastName;
    @NotBlank
    private String secondLastName;
    @NotNull
    @Min(value = 18)
    private Integer age;
    @NotBlank
    @Pattern(regexp = "M|F")
    private String sex;
    @NotBlank
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$")
    private String date;
    @NotBlank
    private String position;
}
