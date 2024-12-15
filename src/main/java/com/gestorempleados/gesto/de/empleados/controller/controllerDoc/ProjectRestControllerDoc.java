package com.gestorempleados.gesto.de.empleados.controller.controllerDoc;

import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.ProjectOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.ProjectInputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectRestControllerDoc {

    @Operation(
            summary = "Create project",
            description = "The method creates a new project by receiving an inputDTO as a parameter.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Requires the following attributes: name, description, registrationDate.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjectOutputDTO.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Example Input",
                                            value = "{" +
                                                    "\"name\" : \"patient manager\"," +
                                                    "\"description\" : \"A project that helps manage hospital patients\"," +
                                                    "\"registrationDate\" : \"2020-12-05\"" +
                                                    "}"
                                    )
                            }
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProjectOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"ID\" : 1," +
                                                            "\"name\" : \"patient manager\"," +
                                                            "\"description\" : \"A project that helps manage hospital patients\"," +
                                                            "\"registrationDate\" : \"2020-12-05\"" +
                                                            "}",
                                                    description = "Returns the created project."
                                            )
                                    }
                            )
                    )
            }
    )
    ResponseEntity<ProjectOutputDTO> createProject(@RequestBody ProjectInputDTO projectInputDTO);

    @Operation(
            summary = "Get all projects",
            description = "The method returns all created projects and implements sorting.",
            parameters = {
                    @Parameter(
                            name = "sort",
                            description = "Specify the sorting order in the format 'field,order'. For example," +
                                    " 'name,asc' or 'name,desc'.",
                            example = "name,asc",
                            in = ParameterIn.QUERY
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProjectOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "[" +
                                                            "{" +
                                                            "\"ID\" : 1," +
                                                            "\"name\" : \"patient manager\"," +
                                                            "\"description\" : \"A project that helps manage hospital patients\"," +
                                                            "\"registrationDate\" : \"2020-12-05\"" +
                                                            "}," +
                                                            "{" +
                                                            "\"ID\" : 1," +
                                                            "\"name\" : \"IOT project\"," +
                                                            "\"description\" : \"A project that connects sensor data to a website\"," +
                                                            "\"registrationDate\" : \"2023-05-25\"" +
                                                            "}" +
                                                            "]"
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Sort parameter cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<ProjectOutputDTO>> getAllProjects(Sort sort);

    @Operation(
            summary = "Get project",
            description = "The method searches for a project by its ID and returns it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the project to retrieve. This ID corresponds to an " +
                                    "existing project in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ProjectOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"ID\" : 1," +
                                                            "\"name\" : \"patient manager\"," +
                                                            "\"description\" : \"A project that helps manage hospital patients\"," +
                                                            "\"registrationDate\" : \"2020-12-05\"" +
                                                            "}"
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Project ID cannot be null.\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Project with ID 2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<ProjectOutputDTO> getProject(@PathVariable Long id);

    @Operation(
            summary = "Patch project",
            description = "This method allows partially updating an entity using the HTTP PATCH method",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the project to be updated. This ID corresponds to an" +
                                    " existing project in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "The attributes that can be updated are: name, description, registrationDate.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProjectInputDTO.class),
                            examples = @ExampleObject(
                                    name = "Example Response",
                                    value = "{" +
                                            "\"name\" : \"patient manager\"," +
                                            "\"description\" : \"A project that helps manage hospital patients\"," +
                                            "\"registrationDate\" : \"2020-12-05\"" +
                                            "}"
                            )
                    )
            ),
            responses ={
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EvaluationOutputDTO.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "{" +
                                                    "\"ID\" : 1," +
                                                    "\"name\" : \"patient manager\"," +
                                                    "\"description\" : \"A project that helps manage hospital patients\"," +
                                                    "\"registrationDate\" : \"2020-12-05\"" +
                                                    "}",
                                            description = "Returns the updated evaluation details."
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Project ID cannot be null.\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Project with ID 2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<ProjectOutputDTO> patchProject(@PathVariable Long id, @RequestBody ProjectInputDTO projectInputDTO);

    @Operation(
            summary = "Delete project",
            description = "The method searches for a project by its ID and deletes it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the project to be delete. This ID corresponds to" +
                                    " an existing project in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "Project 1 was deleted",
                                            description = "Returns a String specifying the ID of the element that has been deleted."
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Project with ID  2 not found\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Project ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> deleteProject(@PathVariable Long id);

    @Operation(
            summary = "Add employee to project",
            description = "This method assigns an employee to a project.",
            parameters = {
                    @Parameter(
                            name = "projectId",
                            description = "The ID of the project to which you will add a new employee.",
                            example = "2",
                            in = ParameterIn.PATH
                    ),
                    @Parameter(
                            name = "employeeId",
                            description = "The ID of the employee to whom you will assign a project.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "Project 1 was deleted",
                                            description = "Returns a String specifying the ID of the element that has been deleted."
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Null ID - Options: \n - Employee ID is Not Found. \n - Project ID is Not Found.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Entity with ID  2 not found\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Not Found - Options: \n - Employee ID is null. \n - Project ID is null.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Entity ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> addEmployeeToProject(@PathVariable Long projectId,@PathVariable Long employeeId);

    @Operation(
            summary = "Get employees by project",
            description = "The method returns a list of employees belonging to the project.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the project to retrieve. This ID corresponds to an " +
                                    "existing project in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeOutputDTO.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "["+
                                                    "{" +
                                                    "\"id\":\"1\"," +
                                                    "\"firstName\":\"Daniel\"," +
                                                    "\"lastName\":\"Cardona\"," +
                                                    "\"email\":\"danicar@hotmail.com\"," +
                                                    "\"hiringDate\":\"2022-05-10\"," +
                                                    "\"salary\": 1500," +
                                                    "\"department\": { " +
                                                    "\"id\": 2," +
                                                    "\"name\":\"Desarrollo de software\"" +
                                                    "}" +
                                                    "},"+
                                                    "{" +
                                                    "\"id\":\"2\"," +
                                                    "\"firstName\":\"Manuela\"," +
                                                    "\"lastName\":\"Gill\"," +
                                                    "\"email\":\"manugill@yahoo.com\"," +
                                                    "\"hiringDate\":\"2020-10-10\"," +
                                                    "\"salary\": 1900," +
                                                    "\"department\": { " +
                                                    "\"id\": 2," +
                                                    "\"name\":\"Desarrollo de software\"" +
                                                    "}" +
                                                    "}"+
                                                    "]",
                                            description = "Returns a list of employees belonging to the project."
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Project with ID  2 not found\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Project ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<EmployeeOutputDTO>> getEmployeesByProject(@PathVariable Long id);
}
