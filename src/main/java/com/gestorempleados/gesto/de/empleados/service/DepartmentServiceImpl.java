package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentInputDTO;
import com.gestorempleados.gesto.de.empleados.mapper.DepartmentMapper;
import com.gestorempleados.gesto.de.empleados.mapper.EmployeeMapper;
import com.gestorempleados.gesto.de.empleados.model.Department;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.repository.DepartmentRepository;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper
            ,EmployeeMapper employeeMapper, EmployeeRepository employeeRepository){
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DepartmentOutputDTO createDepartment(DepartmentInputDTO departmentInputDTO) {

        Department department = departmentMapper.toEntity(departmentInputDTO);

        departmentRepository.save(department);

        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentOutputDTO> getAllDepartments(Sort sort) {

        Objects.requireNonNull(sort, "Sort parameter cannot be null.");

        List<Department> departments = departmentRepository.findAll(sort);

        return departments.stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentOutputDTO getDepartment(Long id) {

        Objects.requireNonNull(id, "Department ID cannot be null.");

        return departmentRepository.findById(id)
                .map(departmentMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Employee with ID " + id + " not found"));
    }

    @Override
    public DepartmentOutputDTO patchDepartment(Long id, DepartmentInputDTO departmentInputDTO) {

        Objects.requireNonNull(id, "Department ID cannot be null.");

        Objects.requireNonNull(departmentInputDTO, "Department input data cannot be null.");

        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Department with ID " + id + " not found"));

        if (departmentInputDTO.getName() != null){
            existingDepartment.setName(departmentInputDTO.getName());
        }

        departmentRepository.save(existingDepartment);

        return departmentMapper.toDto(existingDepartment);

    }

    @Override
    public void deleteDepartment(Long id) {

        Objects.requireNonNull(id, "Department ID cannot be null.");

        Department department = departmentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Department with ID " + id + " not found"));

        for (Employee employee : department.getEmployeeList()){
            employee.setDepartment(null);
            employeeRepository.save(employee);
        }

        departmentRepository.deleteById(id);
    }


    @Override
    public List<EmployeeOutputDTO> getEmployeesByDepartment(Long id) {

        Objects.requireNonNull(id, "Department ID cannot be null.");

        Department department = departmentRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Department with ID "  + id + " not found"));

        return  department.getEmployeeList()
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployeeInDepartment(Long employeeId, Long departmentId) {

        Objects.requireNonNull(employeeId, "Employee ID cannot be null.");

        Objects.requireNonNull(departmentId, "Department ID cannot be null.");

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new EntityNotFoundException("Employee with ID "  + employeeId + " not found"));

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new EntityNotFoundException("Department with ID "  + departmentId + " not found"));

        if(department.equals(employee.getDepartment())){
            throw new IllegalArgumentException("Employee is already part of this department");
        }

        employee.setDepartment(department);

        department.getEmployeeList().add(employee);

        employeeRepository.save(employee);
    }
}
