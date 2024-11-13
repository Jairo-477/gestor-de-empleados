package com.gestorempleados.gesto.de.empleados;

import com.gestorempleados.gesto.de.empleados.model.Department;
import com.gestorempleados.gesto.de.empleados.model.Employee;
import com.gestorempleados.gesto.de.empleados.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestoDeEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestoDeEmpleadosApplication.class, args);
	}
	
}
