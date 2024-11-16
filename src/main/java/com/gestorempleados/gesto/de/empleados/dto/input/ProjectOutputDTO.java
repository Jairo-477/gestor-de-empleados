package com.gestorempleados.gesto.de.empleados.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class ProjectOutputDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDate registrationDate;

    public ProjectOutputDTO(String name, String description, LocalDate registrationDate) {
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
    }
}
