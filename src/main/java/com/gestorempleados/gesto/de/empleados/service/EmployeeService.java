package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.EmployeeDTO;
import com.gestorempleados.gesto.de.empleados.mapper.EmployeeMapper;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Proyect;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public Employee createEmployee (Employee employee){
        return employeeRepository.save(employee);
    }

    public EmployeeDTO getEmployee(Long id){
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElse(null);
    }

    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void putchEmployee(Long id, Employee employee){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        if (!(employee.getFirstName() == null)){
            existingEmployee.setFirstName(employee.getFirstName());
        }
        if (!(employee.getLastName() == null)){
            existingEmployee.setLastName(employee.getLastName());
        }
        if (!(employee.getEmail() == null)){
            existingEmployee.setEmail(employee.getEmail());
        }
        if (!(employee.getSalary() == 0)){
            existingEmployee.setSalary(employee.getSalary());
        }
        if (!(employee.getDepartment() == null)){
            existingEmployee.setDepartment(employee.getDepartment());
        }

        employeeRepository.save(existingEmployee);
    }

    public void addProyect (Long id, Proyect proyect){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        Proyect proyect1 = new Proyect(proyect.getName(),proyect.getDescription(),proyect.getRegistrationDate());

        existingEmployee.getProyects().add(proyect1);

        employeeRepository.save(existingEmployee);
    }

    public Set<Evaluation> getEvaluations (Long id){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        return existingEmployee.getEvaluations();
    }
}
