package com.gestorempleados.gesto.de.empleados.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentInputDTO {

    private String name;

    public DepartmentInputDTO(String name) {
        this.name = name;
    }
}
