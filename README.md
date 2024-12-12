# API REST Gesto de Empleados

**Descripción:**  
El proyecto *Gesto de Empleados* es una aplicación de gestión de empleados utilizando Spring Boot. Permite realizar operaciones CRUD sobre empleados, departamentos, proyectos y evaluaciones. Además, gestiona las relaciones entre estas entidades, como la asignación de empleados a proyectos y departamentos, y la asociación de evaluaciones a empleados.

## Tecnologías utilizadas

- **Spring Boot** (Framework principal)
- **Spring Data JPA** (Para la interacción con bases de datos)
- **MySQL** (Base de datos)
- **Lombok** (Para reducción de código repetitivo)
- **Spring Web** (Para la creación de servicios RESTful)
- **JUnit 5** (Para pruebas unitarias)

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

### Empleados (`/api/employee`)

- **POST** `/api/employee`: Crea un nuevo empleado.
- **GET** `/api/employee/{id}`: Obtiene un empleado por su ID.
- **GET** `/api/employee`: Obtiene una lista de todos los empleados, soportando paginación.
- **DELETE** `/api/employee/{id}`: Elimina un empleado por su ID.
- **PATCH** `/api/employee/{id}`: Actualiza parcialmente un empleado.
- **GET** `/api/employee/evaluations/{id}`: Obtiene las evaluaciones de un empleado.
- **GET** `/api/employee/salary/{salary}`: Busca empleados con un salario mayor que el especificado.

### Departamentos (`/api/department`)

- **POST** `/api/department`: Crea un nuevo departamento.
- **GET** `/api/department`: Obtiene todos los departamentos.
- **GET** `/api/department/{id}`: Obtiene un departamento por su ID.
- **PATCH** `/api/department/{id}`: Actualiza parcialmente un departamento.
- **DELETE** `/api/department/{id}`: Elimina un departamento.
- **GET** `/api/department/employees/{id}`: Obtiene los empleados asignados a un departamento.
- **PATCH** `/api/department/{employeeId}/{departmentId}`: Asigna un empleado a un departamento.

### Evaluaciones (`/api/evaluation`)

- **POST** `/api/evaluation`: Crea una nueva evaluación.
- **GET** `/api/evaluation`: Obtiene todas las evaluaciones.
- **GET** `/api/evaluation/{id}`: Obtiene una evaluación por su ID.
- **PATCH** `/api/evaluation/{id}`: Actualiza parcialmente una evaluación.
- **DELETE** `/api/evaluation/{id}`: Elimina una evaluación.
- **GET** `/api/evaluation/employee/{id}`: Obtiene todas las evaluaciones de un empleado.

### Proyectos (`/api/project`)

- **POST** `/api/project`: Crea un nuevo proyecto.
- **GET** `/api/project`: Obtiene todos los proyectos.
- **GET** `/api/project/{id}`: Obtiene un proyecto por su ID.
- **PATCH** `/api/project/{id}`: Actualiza parcialmente un proyecto.
- **DELETE** `/api/project/{id}`: Elimina un proyecto.
- **PATCH** `/api/project/{projectId}/{employeeId}`: Asigna un empleado a un proyecto.
- **GET** `/api/project/employees/{id}`: Obtiene los empleados asignados a un proyecto.
  
## Configuración de la Base de Datos

Este proyecto utiliza MySQL como base de datos. Para configurarlo, debes crear una base de datos en MySQL y configurar el archivo `application.properties` con la siguiente información:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gesto_de_empleados
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
