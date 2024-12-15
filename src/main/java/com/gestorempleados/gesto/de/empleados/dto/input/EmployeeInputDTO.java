package com.gestorempleados.gesto.de.empleados.dto.input;

import com.gestorempleados.gesto.de.empleados.model.Department;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeInputDTO {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate hiringDate;

    private double salary;

    private Department department;

    private Set<Project> projects = new HashSet<>();

    private Set<Evaluation> evaluations;

    public EmployeeInputDTO(String firstName, String lastName, String email, LocalDate hiringDate, double salary, Department department, Set<Project> projects, Set<Evaluation> evaluations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hiringDate = hiringDate;
        this.salary = salary;
        this.department = department;
        this.projects = projects;
        this.evaluations = evaluations;
    }

    public EmployeeInputDTO(String firstName, String lastName, String email, LocalDate hiringDate, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hiringDate = hiringDate;
        this.salary = salary;
    }
}
