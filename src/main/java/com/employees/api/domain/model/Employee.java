package com.employees.api.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: Employee model whit low coupling for clean architecture .
 * Date: 2025-05-21
 * Version: 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private int age;
    private String sex;
    private LocalDate date;
    private String position;
}
