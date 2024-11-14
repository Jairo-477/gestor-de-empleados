package com.gestorempleados.gesto.de.empleados.dto.output;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor

public class ProjectInputDTO {

    private String name;

    private String description;

    private LocalDate registrationDate;

    private Set<Employee> employees = new HashSet<>();

    public ProjectInputDTO(String name, String description, LocalDate registrationDate, Set<Employee> employees) {
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
        this.employees = employees;
    }
}
