package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeInputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;



public interface EmployeeService {

    List<EmployeeOutputDTO> findBySalaryGreaterThan(Double salary);

    EmployeeOutputDTO createEmployee (EmployeeInputDTO employeeInputDTO);

    EmployeeOutputDTO getEmployee(Long id);

    void deleteEmployee(Long id);

    Page<EmployeeOutputDTO> getAllEmployees(Pageable pageable);

    EmployeeOutputDTO patchEmployee(Long id, EmployeeInputDTO employeeInputDTO);

    Set<EvaluationOutputDTO> getEvaluations (Long id);
}
