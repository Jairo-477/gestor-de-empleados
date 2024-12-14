package com.gestorempleados.gesto.de.empleados.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Gestor De Empleados",
                description = "An employee manager that implements Spring Boot,Spring Data JPA, MySQL",
                version = "1.0.0",
                contact = @Contact(
                        name = "Jairo Alejandro",
                        url = "https://github.com/Jairo-477",
                        email = "jadev@yahoo.com"
                )
        )
)
public class SwaggerConfig {
}
