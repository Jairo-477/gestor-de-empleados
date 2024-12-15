package com.gestorempleados.gesto.de.empleados.controller.controllerDoc;

import com.gestorempleados.gesto.de.empleados.dto.input.DepartmentOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.DepartmentInputDTO;
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


public interface DepartmentRestControllerDoc {

    @Operation(
            summary = "Create department",
            description = "The method creates a new department by receiving an inputDTO as a parameter.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Requires the department name",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DepartmentInputDTO.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Example Input",
                                            value = "{\"name\":\"Software Development\"}"
                                    )
                            }
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DepartmentOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{\"id\": 1, \"name\": \"Software Development\"}"
                                            )
                                    }
                            )
                    )
            }
    )
    ResponseEntity<DepartmentOutputDTO> createDepartment(@RequestBody DepartmentInputDTO departmentInputDTO);

    @Operation(
            summary = "Get sorted list of departments",
            description = "Retrieve a list of departments sorted by a specified field and order.",
            parameters = {
                    @Parameter(
                            name = "sort",
                            description = "Specify the sorting order in the format 'field,order'. For example, 'name,asc' or 'name,desc'.",
                            example = "name,asc",
                            in = ParameterIn.QUERY
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
                                                    value = "{\"id\": 1, \"name\": \"Software Development\"}"
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
                                                    " \"message\" : \"Sort parameter cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<DepartmentOutputDTO>>  getAllDepartments(Sort sort);

    @Operation(
            summary = "Get department by ID",
            description = "The method searches for a department by its ID and returns it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the department to retrieve. This ID corresponds to an " +
                                    "existing department in the system.",
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
                                                    value = "{\"id\": 1, \"name\": \"Software Development\"}"
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
                                                    " \"message\" : \"Department ID cannot be null.\"}"
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
                                                    " \"message\" : \"Department with ID 2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<DepartmentOutputDTO> getDepartment(@PathVariable Long id);

    @Operation(
            summary = "Patch department",
            description = "This method allows partially updating an entity using the HTTP PATCH method",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the department to be updated. This ID corresponds to an existing department in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Requires the name attribute, which is the only attribute available for modification in this endpoint.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DepartmentInputDTO.class),
                            examples = @ExampleObject(
                                    name = "Example input",
                                    value = "{\"name\": \"Software Development\"}"
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DepartmentOutputDTO.class),
                                    examples = @ExampleObject(
                                            name = "Example Response",
                                            value = "{\"id\": 1, \"name\": \"Software Development\"}",
                                            description = "Returns the updated department details."
                                    )
                            )
                    )
            }

    )
    ResponseEntity<DepartmentOutputDTO> patchDepartment(@PathVariable Long id,@RequestBody  DepartmentInputDTO departmentInputDTO);

    @Operation(
            summary = "Delete department",
            description = "The method searches for a department by its ID and deletes it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the department to be delete. This ID corresponds to an existing department in the system.",
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
                                            value = "Department 1 was deleted",
                                            description = "Returns a String specifying the ID of the element that has been deleted."
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
                                                    " \"message\" : \"Department with ID  2 not found\"}"
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
                                                    " \"message\" : \"Department ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> deleteDepartment(@PathVariable Long id);

    @Operation(
        summary = "Get employees by department",
        description = "The method allows us to enter the department ID and view the list of employees assigned to it.",
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique ID of a department whose employees we want to know. This ID" +
                                " corresponds to an existing department in the system.",
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
                                        description = "Returns a list of employee DTOs corresponding to the department of the entered ID.",
                                        value = "["
                                                + "{"
                                                + "\"id\": 1,"
                                                + "\"firstName\": \"John\","
                                                + "\"lastName\": \"Doe\","
                                                + "\"email\": \"john.doe@example.com\","
                                                + "\"hiringDate\": \"2024-12-14\","
                                                + "\"department\": {"
                                                + "\"id\": 101,"
                                                + "\"name\": \"Sales\""
                                                + "}"
                                                + "},"
                                                + "{"
                                                + "\"id\": 2,"
                                                + "\"firstName\": \"Jane\","
                                                + "\"lastName\": \"Smith\","
                                                + "\"email\": \"jane.smith@example.com\","
                                                + "\"hiringDate\": \"2024-12-14\","
                                                + "\"department\": {"
                                                + "\"id\": 102,"
                                                + "\"name\": \"Marketing\""
                                                + "}"
                                                + "}"
                                                + "]"
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
                                                " \"message\" : \"Department with ID  2 not found\"}"
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
                                                " \"message\" : \"Department ID cannot be null.\"}"
                                )
                        )
                )
        }
    )
    ResponseEntity<List<EmployeeOutputDTO>> getEmployeesByDepartment(@PathVariable Long id);

    @Operation(
            summary = "Add employee in department",
            description = "The method allows us to enter the department ID and the employee ID to link an employee" +
                    " to a department.",
            parameters = {
                    @Parameter(
                            name = "employeeId",
                            description = "The ID of the employee we want to assign to a department.",
                            example = "2",
                            in = ParameterIn.PATH
                    ),
                    @Parameter(
                            name = "departmentId",
                            description = "The ID of the department to which we are going to assign a new employee.",
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
                                            description = "Returns a String specifying the department ID and the" +
                                                    " employee ID that was assigned.",
                                            value = "Employee 1 was assigned to department 1"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Resource not found. Possible reasons: \n- Employee with the provided ID does not exist. \n- Department with the provided ID does not exist.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"404\"," +
                                                    " \"error\" : \"Not Found\"," +
                                                    " \"message\" : \"Resource with the given ID was not found.\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request. Possible reasons: \n- Department ID cannot be null. \n- Employee ID cannot be null.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"A required ID cannot be null.\"}"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"422\"," +
                                                    " \"error\" : \"Unprocessable Entity\"," +
                                                    " \"message\" : \"Employee is already part of this department\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> addEmployeeInDepartment(@PathVariable Long employeeId,@PathVariable Long departmentId);
}
