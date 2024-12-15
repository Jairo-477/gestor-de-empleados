package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectInputDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProjectService {

    ProjectOutputDTO createProject(ProjectInputDTO projectInputDTO);

    List<ProjectOutputDTO> getAllProjects(Sort sort);

    ProjectOutputDTO getProject(Long id);

    ProjectOutputDTO patchProject(Long id, ProjectInputDTO projectInputDTO);

    void deleteProject(Long id);

    void addEmployeeToProject(Long projectId, Long employeeId);

    List<EmployeeOutputDTO> getEmployeesByProject(Long id);
}
