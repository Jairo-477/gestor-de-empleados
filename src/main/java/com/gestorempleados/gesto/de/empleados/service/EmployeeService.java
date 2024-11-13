package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.EmployeeDTO;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Proyect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;



public interface EmployeeService {

    List<Employee> findBySalaryGreaterThan(Double salary);

    Employee createEmployee (Employee employee);

    EmployeeDTO getEmployee(Long id);

    void deleteEmployee(Long id);

    Page<Employee> getAllEmployees(Pageable pageable);

    void patchEmployee(Long id, Employee employee);

    void addProyect (Long id, Proyect proyect);

    Set<Evaluation> getEvaluations (Long id);
}
