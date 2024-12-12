# API REST Gestor de Empleados

**Descripción:**  
El proyecto *Gesto de Empleados* es una aplicación de gestión de empleados utilizando Spring Boot. Permite realizar operaciones CRUD sobre empleados, departamentos, proyectos y evaluaciones. Además, gestiona las relaciones entre estas entidades, como la asignación de empleados a proyectos y departamentos, y la asociación de evaluaciones a empleados.

## Tecnologías utilizadas
- **Java 21** (Lenguaje de programación principal)
- **Spring Boot 3.3.4** (Framework principal)
- **Spring Data JPA** (Para la interacción con bases de datos)
- **MySQL** (Base de datos)
- **Lombok** (Para reducción de código repetitivo)
- **Spring Web** (Para la creación de servicios RESTful)


## Estructura del Proyecto

El proyecto está dividido en varias capas para una mejor organización del código:

- **Controller**: Contiene las clases encargadas de recibir las solicitudes HTTP y devolver las respuestas correspondientes.
- **Service**: Contiene la lógica de negocio de la aplicación.
- **Repository**: Contiene las interfaces de repositorios para interactuar con la base de datos.
- **Model**: Contiene las entidades que representan las tablas en la base de datos.
- **DTO**: Contiene los objetos de transferencia de datos (Data Transfer Objects).
- **Mapper**: Contiene las clases encargadas de convertir las entidades en DTOs y viceversa.
- **Exception**: Manejo de excepciones personalizadas.

## Endpoints

### Empleados (`/api/employees`)

- **POST** `/api/employees`: Crea un nuevo empleado.
- **GET** `/api/employees/{id}`: Obtiene un empleado por su ID.
- **GET** `/api/employees`: Obtiene una lista de todos los empleados, soportando paginación.
- **DELETE** `/api/employees/{id}`: Elimina un empleado por su ID.
- **PATCH** `/api/employees/{id}`: Actualiza parcialmente un empleado.
- **GET** `/api/employees/evaluations/{id}`: Obtiene las evaluaciones de un empleado.
- **GET** `/api/employees/salary/{salary}`: Busca empleados con un salario mayor que el especificado.

### Departamentos (`/api/departments`)

- **POST** `/api/departments`: Crea un nuevo departamento.
- **GET** `/api/departments`: Obtiene todos los departamentos.
- **GET** `/api/departments/{id}`: Obtiene un departamento por su ID.
- **PATCH** `/api/departments/{id}`: Actualiza parcialmente un departamento.
- **DELETE** `/api/departments/{id}`: Elimina un departamento.
- **GET** `/api/departments/employees/{id}`: Obtiene los empleados asignados a un departamento.
- **PATCH** `/api/department/{departmentId}/employee/{employeeId}`: Asigna un empleado a un departamento.

### Evaluaciones (`/api/evaluations`)

- **POST** `/api/evaluations`: Crea una nueva evaluación.
- **GET** `/api/evaluations`: Obtiene todas las evaluaciones.
- **GET** `/api/evaluations/{id}`: Obtiene una evaluación por su ID.
- **PATCH** `/api/evaluations/{id}`: Actualiza parcialmente una evaluación.
- **DELETE** `/api/evaluations/{id}`: Elimina una evaluación.
- **GET** `/api/evaluations/employee/{id}`: Obtiene todas las evaluaciones de un empleado.

### Proyectos (`/api/projects`)

- **POST** `/api/projects`: Crea un nuevo proyecto.
- **GET** `/api/projects`: Obtiene todos los proyectos.
- **GET** `/api/projects/{id}`: Obtiene un proyecto por su ID.
- **PATCH** `/api/projects/{id}`: Actualiza parcialmente un proyecto.
- **DELETE** `/api/projects/{id}`: Elimina un proyecto.
- **PATCH** `/api/projects/{projectId}/employee/{employeeId}`: Asigna un empleado a un proyecto.
- **GET** `/api/projects/employees/{id}`: Obtiene los empleados asignados a un proyecto.
  
## Configuración de la Base de Datos

Este proyecto utiliza MySQL como base de datos. Para configurarlo, debes crear una base de datos en MySQL y configurar el archivo `application.properties` con la siguiente información:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gesto_de_empleados
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
