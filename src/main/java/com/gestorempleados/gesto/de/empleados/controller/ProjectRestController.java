package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
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

        return ResponseEntity.ok(projectService.getAllProjects(sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectOutputDTO> getProject(@PathVariable Long id) {

        return ResponseEntity.ok(projectService.getProject(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectOutputDTO> patchProject(@PathVariable Long id, @RequestBody ProjectInputDTO projectInputDTO) {

        return ResponseEntity.ok(projectService.patchProject(id, projectInputDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){

        projectService.deleteProject(id);
        return ResponseEntity.ok("Project " + id + " was deleted");

    }

    @PatchMapping("/{projectId}/employee/{employeeId}")
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
