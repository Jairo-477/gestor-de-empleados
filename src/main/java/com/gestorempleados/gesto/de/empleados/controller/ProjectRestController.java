package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {

    private final ProjectService projectService;

    @Autowired
    public ProjectRestController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectOutputDTO> createProject(@RequestBody ProjectInputDTO projectInputDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectInputDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProjectOutputDTO>> getAllProjects(Sort sort){

        List<ProjectOutputDTO> projectsOutput = projectService.getAllProjects(sort);
        return ResponseEntity.ok(projectsOutput);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutputDTO> getProject(@PathVariable Long id) {

        ProjectOutputDTO projectOutput = projectService.getProject(id);
        return ResponseEntity.ok(projectOutput);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectOutputDTO> patchProject(@PathVariable Long id, @RequestBody ProjectInputDTO projectInputDTO) {

        ProjectOutputDTO projectOutput = projectService.patchProject(id, projectInputDTO);
        return ResponseEntity.ok(projectOutput);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){

        projectService.deleteProject(id);
        return ResponseEntity.ok("Project " + id + " was deleted");

    }

    @PatchMapping("/{projectId}/{employeeId}")
    public ResponseEntity<String> addEmployeeToProject(@PathVariable Long projectId,@PathVariable Long employeeId){

        projectService.addEmployeeToProject(projectId,employeeId);
        return ResponseEntity.ok("Employee " + employeeId + " has been added to Project " + projectId);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<List<EmployeeOutputDTO>> getEmployeesByProject(@PathVariable Long id) {

        List<EmployeeOutputDTO> employees = projectService.getEmployeesByProject(id);
        return ResponseEntity.ok(employees);
    }
}
