package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.controller.controllerDoc.DepartmentRestControllerDoc;
import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentInputDTO;
import com.gestorempleados.gesto.de.empleados.service.DepartmentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag( name = "Department ", description = "Controller for Department")
public class DepartmentRestController implements DepartmentRestControllerDoc {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentOutputDTO> createDepartment(@RequestBody DepartmentInputDTO departmentInputDTO) {

        return ResponseEntity.ok(departmentService.createDepartment(departmentInputDTO));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentOutputDTO>>  getAllDepartments(Sort sort) {

        return ResponseEntity.ok(departmentService.getAllDepartments(sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentOutputDTO> getDepartment(@PathVariable Long id) {

        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentOutputDTO> patchDepartment(@PathVariable Long id,@RequestBody  DepartmentInputDTO departmentInputDTO) {

        return ResponseEntity.ok(departmentService.patchDepartment(id, departmentInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){

        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department " + id + " was deleted");
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<List<EmployeeOutputDTO>> getEmployeesByDepartment(@PathVariable Long id){

        return ResponseEntity.ok(departmentService.getEmployeesByDepartment(id));
    }

    @PatchMapping("/{departmentId}/employee/{employeeId}")
    public ResponseEntity<String> addEmployeeInDepartment(@PathVariable Long employeeId,@PathVariable Long departmentId) {

        departmentService.addEmployeeInDepartment(employeeId,departmentId);
        return ResponseEntity.ok("Employee " + employeeId + " was assigned to department " + departmentId);
    }
}
