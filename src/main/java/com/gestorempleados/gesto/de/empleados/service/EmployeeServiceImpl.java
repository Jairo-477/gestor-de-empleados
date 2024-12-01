package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeInputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.mapper.EmployeeMapper;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.model.Project;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
        employeeRepository.save(employee);

        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeOutputDTO getEmployee(Long id){

        if (id == null){
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }

        return employeeRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));
    }

    @Override
        public void deleteEmployee(Long id){

        if (id == null){
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }

        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeOutputDTO> getAllEmployees(Pageable pageable){

        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.map(employeeMapper::toDto);
    }

    @Override
    public EmployeeOutputDTO patchEmployee(Long id, EmployeeInputDTO employeeInputDTO){

        if (id == null){
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }
        if (employeeInputDTO == null){
            throw new IllegalArgumentException("Employee input data cannot be null.");
        }

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        if (!(employeeInputDTO.getFirstName() == null)){
            existingEmployee.setFirstName(employeeInputDTO.getFirstName());
        }
        if (!(employeeInputDTO.getLastName() == null)){
            existingEmployee.setLastName(employeeInputDTO.getLastName());
        }
        if (!(employeeInputDTO.getEmail() == null)){
            existingEmployee.setEmail(employeeInputDTO.getEmail());
        }
        if (!(employeeInputDTO.getSalary() == 0)){
            existingEmployee.setSalary(employeeInputDTO.getSalary());
        }
        if (!(employeeInputDTO.getDepartment() == null)){
            existingEmployee.setDepartment(employeeInputDTO.getDepartment());
        }

        employeeRepository.save(existingEmployee);

        return employeeMapper.toDto(existingEmployee);
    }

    @Override
    public Set<Evaluation> getEvaluations (Long id){

        if (id == null){
            throw new IllegalArgumentException("Employee ID cannot be null.");
        }

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        return existingEmployee.getEvaluations();
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Double salary){

        if (salary == null){
            throw new IllegalArgumentException("The value cannot be null");
        }

        return employeeRepository.findBySalaryGreaterThan(salary);
    };
}
