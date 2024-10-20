package com.gestorempleados.gesto.de.empleados.dto;

import com.gestorempleados.gesto.de.empleados.model.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EmployeeDTO {

    private  Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate hiringDate;

    private Department department;

    public EmployeeDTO(Long id, String firstName, String lastName, String email, LocalDate hiringDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hiringDate = hiringDate;
    }
}
