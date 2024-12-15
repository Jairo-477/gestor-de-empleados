package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentInputDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DepartmentService {

    DepartmentOutputDTO createDepartment(DepartmentInputDTO departmentInputDTO);

    List<DepartmentOutputDTO> getAllDepartments(Sort sort);

    DepartmentOutputDTO getDepartment (Long id);

    DepartmentOutputDTO patchDepartment (Long id, DepartmentInputDTO departmentInputDTO);

    void deleteDepartment(Long id);

    List<EmployeeOutputDTO> getEmployeesByDepartment(Long id);

    void addEmployeeInDepartment(Long employeeId, Long departmentId);
}
