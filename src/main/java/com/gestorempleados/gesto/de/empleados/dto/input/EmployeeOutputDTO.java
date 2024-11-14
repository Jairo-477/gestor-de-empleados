package com.gestorempleados.gesto.de.empleados.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeOutputDTO {

    private  Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate hiringDate;

    public EmployeeOutputDTO(Long id, String firstName, String lastName, String email, LocalDate hiringDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hiringDate = hiringDate;
    }
}
