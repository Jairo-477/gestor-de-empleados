package com.gestorempleados.gesto.de.empleados.dto.output;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentOutputDTO {

    private Long id;
    private String name;

    public DepartmentOutputDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
