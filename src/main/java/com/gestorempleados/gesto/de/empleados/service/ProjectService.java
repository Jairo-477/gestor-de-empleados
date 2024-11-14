package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Project;

public interface ProjectService {

    Project createProject(ProjectInputDTO projectInputDTO);
}
