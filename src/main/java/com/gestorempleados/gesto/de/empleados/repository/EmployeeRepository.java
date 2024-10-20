package com.gestorempleados.gesto.de.empleados.repository;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
