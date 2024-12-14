package com.gestorempleados.gesto.de.empleados.dto.output;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentInputDTO {

    private String name;

    public DepartmentInputDTO(String name) {
        this.name = name;
    }
}
