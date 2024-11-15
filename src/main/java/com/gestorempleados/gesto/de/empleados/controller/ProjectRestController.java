package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Project;
import com.gestorempleados.gesto.de.empleados.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
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

    public ProjectRestController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Object> createProject(@RequestBody ProjectInputDTO projectInputDTO) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectInputDTO));
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid project data provided");
        }catch (HttpMessageNotReadableException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Malformed JSON request.");
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllProjects(Sort sort){

        List<ProjectOutputDTO> projectsOutput = projectService.getAllProjects(sort);

        return ResponseEntity.ok(projectsOutput);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProject(@PathVariable Long id) {

        try {
            ProjectOutputDTO projectOutput = projectService.getProject(id);
            return ResponseEntity.ok(projectOutput);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project with ID " + id + " not found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchProject(@PathVariable Long id, @RequestBody ProjectInputDTO projectInputDTO) {

        try {
            ProjectOutputDTO projectOutput = projectService.patchProject(id, projectInputDTO);
            return ResponseEntity.ok(projectOutput);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
