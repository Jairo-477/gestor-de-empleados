package com.gestorempleados.gesto.de.empleados.mapper;


import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeOutputDTO toDto(Employee employee) {

        DepartmentOutputDTO departmentDto = null;
        if (employee.getDepartment() != null){
            departmentDto = new DepartmentOutputDTO(
                    employee.getDepartment().getId(),
                    employee.getDepartment().getName()
            );
        }

        return new EmployeeOutputDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getHiringDate(),
                departmentDto
        );
    }

    public Employee toEntity(EmployeeInputDTO employeeInputDTO){
        return new Employee(
                employeeInputDTO.getFirstName(),
                employeeInputDTO.getLastName(),
                employeeInputDTO.getEmail(),
                employeeInputDTO.getHiringDate(),
                employeeInputDTO.getSalary()
        );
    }


}
