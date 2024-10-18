package com.gestorempleados.gesto.de.empleados.service;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
}
