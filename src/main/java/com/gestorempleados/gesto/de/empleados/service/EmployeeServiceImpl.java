package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeInputDTO;
import com.gestorempleados.gesto.de.empleados.mapper.EmployeeMapper;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Project;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeOutputDTO createEmployee (EmployeeInputDTO employeeInputDTO){
        Employee employee = employeeMapper.toEntity(employeeInputDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeOutputDTO getEmployee(Long id){
        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElse(null);
    }

    @Override
    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeOutputDTO> getAllEmployees(Pageable pageable){

        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.map(employeeMapper::toDto);
    }

    @Override
    public void patchEmployee(Long id, Employee employee){

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

    @Override
    public void addProject (Long id, Project project){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        Project project1 = new Project(project.getName(),project.getDescription(),project.getRegistrationDate());

        existingEmployee.getProjects().add(project1);

        employeeRepository.save(existingEmployee);
    }

    @Override
    public Set<Evaluation> getEvaluations (Long id){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        return existingEmployee.getEvaluations();
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Double salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    };
}
