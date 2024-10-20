package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee (Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Long id){
        return employeeRepository.findById(id);
    }
}
