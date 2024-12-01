package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Project;
import com.gestorempleados.gesto.de.empleados.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @PostMapping
    public EmployeeOutputDTO createEmployee(@RequestBody EmployeeInputDTO employeeInputDTO){

        return employeeService.createEmployee(employeeInputDTO);
    }

    @GetMapping("/{id}")
    public EmployeeOutputDTO getEmployee(@PathVariable Long id){

        return employeeService.getEmployee(id);
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeOutputDTO>> getAllEmployees(Pageable pageable){

        Page<EmployeeOutputDTO> employees = employeeService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee " + id + " was eliminated");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeOutputDTO> patchEmployee(@PathVariable Long id, @RequestBody EmployeeInputDTO employeeInputDTO) {

        return ResponseEntity.ok().body(employeeService.patchEmployee(id, employeeInputDTO));
    }

    @GetMapping("/evaluations/{id}")
    public ResponseEntity<Set<Evaluation>> getEvaluations(@PathVariable Long id){

        Set<Evaluation> evaluations = employeeService.getEvaluations(id);
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> FindBySalaryGreaterThan(@PathVariable Double salary){
        return employeeService.findBySalaryGreaterThan(salary);
    }
}
