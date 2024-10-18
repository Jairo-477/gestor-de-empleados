package com.gestorempleados.gesto.de.empleados.repository;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
