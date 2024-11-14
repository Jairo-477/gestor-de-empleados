package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
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
    public Employee createEmployee(@RequestBody EmployeeInputDTO employeeInputDTO){
        return employeeService.createEmployee(employeeInputDTO);
    }

    @GetMapping("/{id}")
    public EmployeeOutputDTO getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmployees(Pageable pageable){

        Page<EmployeeOutputDTO> employees = employeeService.getAllEmployees(pageable);

        if (employees.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            employeeService.patchEmployee(id, employee);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/addProject/{id}")
    public ResponseEntity<Object> addProject (Long id, Project project){
        try {
            employeeService.addProject(id,project);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/evaluations/{id}")
    public ResponseEntity<Set<Evaluation>> getEvaluations(@PathVariable Long id){
        try {
            Set<Evaluation> evaluations = employeeService.getEvaluations(id);
            return ResponseEntity.ok(evaluations);
        }catch (EntityNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> FindBySalaryGreaterThan(@PathVariable Double salary){
        return employeeService.findBySalaryGreaterThan(salary);
    }
}
