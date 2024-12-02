package com.gestorempleados.gesto.de.empleados.mapper;

import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectOutputDTO toDTO (Project project){
        return new ProjectOutputDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getRegistrationDate()
        );
    }

    public Project toEntity (ProjectInputDTO projectInputDTO){

        return new Project(
                projectInputDTO.getName(),
                projectInputDTO.getDescription(),
                projectInputDTO.getRegistrationDate()
        );
    }
}
