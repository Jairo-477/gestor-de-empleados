package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.mapper.EmployeeMapper;
import com.gestorempleados.gesto.de.empleados.mapper.ProjectMapper;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.model.Project;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import com.gestorempleados.gesto.de.empleados.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    public final ProjectRepository projectRepository;
    public final ProjectMapper projectMapper;
    public final EmployeeRepository employeeRepository;
    public final EmployeeMapper employeeMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper
            , EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public ProjectOutputDTO createProject(ProjectInputDTO projectInputDTO) {

        Project project = projectMapper.toEntity(projectInputDTO);
        projectRepository.save(project);

        return projectMapper.toDTO(project);
    }

    @Override
    public List<ProjectOutputDTO> getAllProjects(Sort sort) {

        List<Project> projectsEntity = projectRepository.findAll(sort);

        return projectsEntity.stream()
                .map(projectMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectOutputDTO getProject(Long id) {

        return projectRepository.findById(id)
                .map(projectMapper::toDTO)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public ProjectOutputDTO patchProject(Long id, ProjectInputDTO projectInputDTO) {

        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));

        if(projectInputDTO.getName() != null){
            existingProject.setName(projectInputDTO.getName());
        }
        if (projectInputDTO.getDescription() != null){
            existingProject.setDescription(projectInputDTO.getDescription());
        }
        if (projectInputDTO.getRegistrationDate() != null){
            existingProject.setRegistrationDate(projectInputDTO.getRegistrationDate());
        }

        projectRepository.save(existingProject);

        return (projectMapper.toDTO(existingProject));
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void addEmployeeToProject(Long projectId, Long employeeId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(EntityNotFoundException::new);

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(EntityNotFoundException::new);

        project.getEmployees().add(employee);
    }

    @Override
    public List<EmployeeOutputDTO> getEmployeesByProject(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return project.getEmployees().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }


}
