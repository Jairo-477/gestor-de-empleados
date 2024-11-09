package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.EmployeeDTO;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Proyect;
import com.gestorempleados.gesto.de.empleados.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmployees(){

        List<Employee> employees = employeeService.getAllEmployees();

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
    public ResponseEntity<Object> putchEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            employeeService.putchEmployee(id, employee);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/addProyect/{id}")
    public ResponseEntity<Object> addProyect (Long id, Proyect proyect){
        try {
            employeeService.addProyect(id,proyect);
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
}
