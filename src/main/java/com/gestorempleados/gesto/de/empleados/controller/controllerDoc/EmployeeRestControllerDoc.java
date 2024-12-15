package com.gestorempleados.gesto.de.empleados.controller.controllerDoc;

import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeInputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;


public interface EmployeeRestControllerDoc {

    @Operation(
            summary = "Create employee",
            description = "The method creates a new employee by receiving an input TO as a parameter.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "requires receiving the following attributes: firstName, lastName, email, hiringDate, salary",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeInputDTO.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Example input",
                                            value = "{" +
                                                    "\"firstName\":\"Daniel\"," +
                                                    "\"lastName\":\"Cardona\"," +
                                                    "\"email\":\"danicar@hotmail.com\"," +
                                                    "\"hiringDate\":\"2022-05-10\"," +
                                                    "\"salary\": 1500" +
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
                                    schema = @Schema(implementation = EmployeeOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"id\":\"1\"," +
                                                            "\"firstName\":\"Daniel\"," +
                                                            "\"lastName\":\"Cardona\"," +
                                                            "\"email\":\"danicar@hotmail.com\"," +
                                                            "\"hiringDate\":\"2022-05-10\"," +
                                                            "\"salary\": 1500," +
                                                            "\"department\": null" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }

    )
    EmployeeOutputDTO createEmployee(@RequestBody EmployeeInputDTO employeeInputDTO);

    @Operation(
            summary = "Get employee by ID",
            description = "The method searches for a employee by its ID and returns it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the employee to retrieve. This ID corresponds to an existing department in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DepartmentOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"id\":\"1\"," +
                                                            "\"firstName\":\"Daniel\"," +
                                                            "\"lastName\":\"Cardona\"," +
                                                            "\"email\":\"danicar@hotmail.com\"," +
                                                            "\"hiringDate\":\"2022-05-10\"," +
                                                            "\"salary\": 1500," +
                                                            "\"department\": { " +
                                                            "\"id\": 1," +
                                                            "\"name\":\"Desarrollo de software\"" +
                                                            "}" +
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
                                            example = "{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Employee ID cannot be null.\"}"
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
                                                    " \"message\" : \"Employee with ID 2 not found\"}"
                                    )
                            )
                    )
            }
    )
    EmployeeOutputDTO getEmployee(@PathVariable Long id);

    @Operation(
            summary = "Get all employees",
            description = "This method returns all created employees and implements Pageable.",
            parameters = {
                    @Parameter(
                            name = "page",
                            description = "The page number (0-based index). Default is 0.",
                            example = "0",
                            in = ParameterIn.QUERY
                    ),
                    @Parameter(
                            name = "size",
                            description = "The number of elements per page. Default is 20,",
                            example = "10",
                            in = ParameterIn.QUERY
                    ),
                    @Parameter(
                            name = "sort",
                            description = "Sorting criteria in the format: property(,asc|desc). Default is ascending." +
                                    " You can specify multiple sorting criteria separated by commas.",
                            example = "fistName,desc",
                            in = ParameterIn.QUERY
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
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
                                                            "\"id\": 1," +
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
                                                            "\"name\":\"Desarrollo de hardware\"" +
                                                            "}" +
                                                            "}"+
                                                            "]"
                                            )
                                    }
                            )
                    ),
            }

    )
    ResponseEntity<Page<EmployeeOutputDTO>> getAllEmployees(Pageable pageable);

    @Operation(
            summary = "Delete employee",
            description = "The method searches for a employee by its ID and deletes it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the employee to be delete. This ID corresponds to an" +
                                    " existing employee in the system.",
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
                                            value = "Employee 1 was deleted",
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
                                                    " \"message\" : \"Employee with ID  2 not found\"}"
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
                                                    " \"message\" : \"Employee ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> deleteEmployee(@PathVariable Long id);

    @Operation(
            summary = "Patch employee",
            description = "This method allows partially updating an entity using the HTTP PATCH method",
            parameters = {
                    @Parameter(
                            name = "id",
                            description =
                                    "The unique ID of the employee to be updated. This ID corresponds to an existing" +
                                            " employee in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "It can receive one or more of the following attributes to be updated: firstName," +
                            " lastName, email, hiringDate, salary.",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeInputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example input",
                                                    value = "{" +
                                                            "\"firstName\":\"Daniel\"," +
                                                            "\"lastName\":\"Cardona\"," +
                                                            "\"email\":\"danicar@hotmail.com\"," +
                                                            "\"hiringDate\":\"2022-05-10\"," +
                                                            "\"salary\": 1500" +
                                                            "}"
                                            )
                                    }
                            )
                    }
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DepartmentOutputDTO.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "{" +
                                                    "\"id\":\"1\"," +
                                                    "\"firstName\":\"Daniel\"," +
                                                    "\"lastName\":\"Cardona\"," +
                                                    "\"email\":\"danicar@hotmail.com\"," +
                                                    "\"hiringDate\":\"2022-05-10\"," +
                                                    "\"salary\": 1500," +
                                                    "\"department\": null" +
                                                    "}",
                                            description = "Returns the updated employee details."
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
                                                    " \"message\" : \"Employee ID cannot be null.\"}"
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
                                                    " \"message\" : \"Employee with ID  2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<EmployeeOutputDTO> patchEmployee(@PathVariable Long id, @RequestBody EmployeeInputDTO employeeInputDTO);

    @Operation(
            summary = "Get evaluations",
            description = "This method returns the list of all evaluations assigned to an employee.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The ID that identifies the employee whose evaluations we want to retrieve.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EvaluationOutputDTO.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "[" +
                                                    "{" +
                                                    "\"evaluationId\":1," +
                                                    " \"employeeId\" : 2," +
                                                    " \"qualification\" : 50," +
                                                    " \"comment\" : \"Did not meet the project requirements.\"," +
                                                    " \"evaluationDate\" : \"2024-10-05\"" +
                                                    "}," +
                                                    "{" +
                                                    "\"evaluationId\":2," +
                                                    " \"employeeId\" : 2," +
                                                    " \"qualification\" : 75," +
                                                    " \"comment\" : \"Did not meet the project requirements.\"," +
                                                    " \"evaluationDate\" : \"2024-10-05\"" +
                                                    "}" +
                                                    "]",
                                            description = "Met the basic expectations of the project."
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
                                                    " \"message\" : \"Employee ID cannot be null.\"}"
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
                                                    " \"message\" : \"Employee with ID  2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<Set<EvaluationOutputDTO>> getEvaluations(@PathVariable Long id);

    @Operation(
            summary = "Find By Salary Greater Than",
            description = "This method returns the employees who have a salary higher than the one entered as the parameter.",
            parameters = {
                    @Parameter(
                            name = "salary",
                            description = "The salary value is entered to filter employees with a salary higher than" +
                                    " the specified amount.",
                            example = "2000",
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
                                                    "\"salary\": 2200," +
                                                    "\"department\": null" +
                                                    "},"+
                                                    "{" +
                                                    "\"id\":\"1\"," +
                                                    "\"firstName\":\"Daniel\"," +
                                                    "\"lastName\":\"Cardona\"," +
                                                    "\"email\":\"danicar@hotmail.com\"," +
                                                    "\"hiringDate\":\"2022-05-10\"," +
                                                    "\"salary\": 1500," +
                                                    "\"department\": null" +
                                                    "}"+
                                                    "]",
                                            description = "Returns the list of employees who meet the condition of " +
                                                    "having a salary higher than the specified parameter."
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
                                                    " \"message\" : \"The value cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    List<EmployeeOutputDTO> FindBySalaryGreaterThan(@RequestParam Double salary);
}
