package com.gestorempleados.gesto.de.empleados.mapper;

import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentOutputDTO toDto(Department department){

        return new DepartmentOutputDTO(
                department.getId(),
                department.getName()
        );
    }

    public Department toEntity(DepartmentInputDTO departmentInputDTO){
        return new Department(departmentInputDTO.getName());
    }
}
