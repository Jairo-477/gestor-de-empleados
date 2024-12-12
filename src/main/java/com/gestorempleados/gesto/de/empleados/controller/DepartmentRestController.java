package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentInputDTO;
import com.gestorempleados.gesto.de.empleados.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {

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

        List<DepartmentOutputDTO> departments = departmentService.getAllDepartments(sort);

        return ResponseEntity.ok(departments);
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
}
