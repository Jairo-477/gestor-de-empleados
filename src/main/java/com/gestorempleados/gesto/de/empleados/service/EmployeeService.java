package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;



public interface EmployeeService {

    List<Employee> findBySalaryGreaterThan(Double salary);

    EmployeeOutputDTO createEmployee (EmployeeInputDTO employeeInputDTO);

    EmployeeOutputDTO getEmployee(Long id);

    void deleteEmployee(Long id);

    Page<EmployeeOutputDTO> getAllEmployees(Pageable pageable);

    void patchEmployee(Long id, Employee employee);

    void addProject (Long id, Project project);

    Set<Evaluation> getEvaluations (Long id);
}
