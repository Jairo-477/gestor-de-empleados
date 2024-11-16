package com.gestorempleados.gesto.de.empleados.mapper;

import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectOutputDTO toDTO (Project project){

        ProjectOutputDTO projectOutputDTO = new ProjectOutputDTO();

        projectOutputDTO.setId(project.getId());
        projectOutputDTO.setName(project.getName());
        projectOutputDTO.setDescription(project.getDescription());
        projectOutputDTO.setRegistrationDate(project.getRegistrationDate());

        return projectOutputDTO;
    }

    public Project toEntity (ProjectInputDTO projectInputDTO){

        Project project = new Project();

        project.setName(projectInputDTO.getName());
        project.setDescription(projectInputDTO.getDescription());
        project.setRegistrationDate(projectInputDTO.getRegistrationDate());

        return project;
    }
}
