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

    private Long id;
    private String name;
    private Set<Employee> employeeList;

    public DepartmentInputDTO(String name, Set<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public DepartmentInputDTO(String name) {
        this.name = name;
    }
}
