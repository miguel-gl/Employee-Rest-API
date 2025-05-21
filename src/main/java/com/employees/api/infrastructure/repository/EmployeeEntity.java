package com.employees.api.infrastructure.repository;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Miguel Angel Gonzalez Lopez
 * Description: EmployeeEntity entioty represents de table on DB.
 * Date: 2025-05-21
 * Version: 1.0
 */


@Entity
@Table(name = "employees")
@Getter
@Setter
public class EmployeeEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "first_last_name", nullable = false)
    private String firstLastName;

    @Column(name = "second_last_name", nullable = false)
    private String secondLastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String position;
}
