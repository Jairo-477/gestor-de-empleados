package com.gestorempleados.gesto.de.empleados.controller.controllerDoc;

import com.gestorempleados.gesto.de.empleados.dto.output.EmployeeOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.input.EvaluationInputDTO;
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

public interface EvaluationRestControllerDoc {


    @Operation(
            summary = "Create evaluation",
            description = "The method creates a new evaluation by receiving an inputDTO as a parameter.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Requires the following attributes: employee ID, qualification, comment, evaluationDate.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EvaluationInputDTO.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Example Input",
                                            value = "{"+
                                                    "\"employee \" : {"+
                                                    "\"id\" : 1"+
                                                    "},"+
                                                    "\"qualification\" : 20,"+
                                                    "\"comment\" : \"Did not meet all the proposed goals.\","+
                                                    "\"evaluationDate\" : \"2024-10-05\""+
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
                                    schema = @Schema(implementation = EvaluationOutputDTO.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"evaluationId\":1," +
                                                            " \"employeeId\" : 2," +
                                                            " \"qualification\" : 50," +
                                                            " \"comment\" : \"Did not meet the project requirements.\"," +
                                                            " \"evaluationDate\" : \"2024-10-05\"" +
                                                            "}",
                                                    description = "Returns the created evaluation."
                                            )
                                    }
                            )
                    )
            }
    )
    ResponseEntity<EvaluationOutputDTO> createEvaluation (@RequestBody EvaluationInputDTO evaluationInputDTO);

    @Operation(
            summary = "Get all evaluations",
            description = "The method returns all created evaluations and implements sorting.",
            parameters = {
                    @Parameter(
                            name = "sort",
                            description = "Specify the sorting order in the format 'field,order'. For example," +
                                    " 'evaluationId,asc' or 'evaluationId,desc'.",
                            example = "evaluationId,asc",
                            in = ParameterIn.QUERY
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EvaluationOutputDTO.class),
                                    examples ={
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "["+
                                                            "{" +
                                                            "\"evaluationId\":1," +
                                                            " \"employeeId\" : 2," +
                                                            " \"qualification\" : 50," +
                                                            " \"comment\" : \"Did not meet the project requirements.\"," +
                                                            " \"evaluationDate\" : \"2024-10-05\"" +
                                                            "},"+
                                                            "{" +
                                                            "\"evaluationId\":2," +
                                                            " \"employeeId\" : 2," +
                                                            " \"qualification\" : 90," +
                                                            " \"comment\" : \"Meet project requirements.\"," +
                                                            " \"evaluationDate\" : \"2024-06-15\"" +
                                                            "}"+
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
                                            example ="{\"localDateTime\":\"2024-12-13 15:30:00\"," +
                                                    " \"status\" : \"400\"," +
                                                    " \"error\" : \"NullPointerException\"," +
                                                    " \"message\" : \"Sort parameter cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<EvaluationOutputDTO>> getAllEvaluations(Sort sort);

    @Operation(
            summary = "Get evaluation",
            description = "The method searches for a evaluation by its ID and returns it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the evaluation to retrieve. This ID corresponds to an " +
                                    "existing evaluation in the system.",
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
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example Response",
                                                    value = "{" +
                                                            "\"evaluationId\":2," +
                                                            " \"employeeId\" : 6," +
                                                            " \"qualification\" : 90," +
                                                            " \"comment\" : \"Meet project requirements.\"," +
                                                            " \"evaluationDate\" : \"2024-06-15\"" +
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
                                                    " \"message\" : \"Evaluation ID cannot be null.\"}"
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
                                                    " \"message\" : \"Evaluation with ID 2 not found\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<EvaluationOutputDTO> getEvaluation(@PathVariable Long id);

    @Operation(
            summary = "Patch evaluation",
            description = "This method allows partially updating an entity using the HTTP PATCH method",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the evaluation to be updated. This ID corresponds to an" +
                                    " existing evaluation in the system.",
                            example = "2",
                            in = ParameterIn.PATH
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "The attributes that can be updated are: employee id, qualification, comment, evaluationDate.",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = EvaluationInputDTO.class),
                            examples = @ExampleObject(
                                    name = "Example Response",
                                    value = "{"+
                                            "\"employee \" : {"+
                                            "\"id\" : 1"+
                                            "},"+
                                            "\"qualification\" : 20,"+
                                            "\"comment\" : \"Did not meet all the proposed goals.\","+
                                            "\"evaluationDate\" : \"2024-10-05\""+
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
                                                    "\"evaluationId\":2," +
                                                    " \"employeeId\" : 6," +
                                                    " \"qualification\" : 90," +
                                                    " \"comment\" : \"Meet project requirements.\"," +
                                                    " \"evaluationDate\" : \"2024-06-15\"" +
                                                    "}",
                                            description = "Returns the updated evaluation details."
                                    )
                            )
                    )
            }
    )
    ResponseEntity<EvaluationOutputDTO> patchEvaluation(@PathVariable Long id, @RequestBody EvaluationInputDTO evaluationInputDTO);

    @Operation(
            summary = "Delete evaluation",
            description = "The method searches for a evaluation by its ID and deletes it.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the evaluation to be delete. This ID corresponds to" +
                                    " an existing evaluation in the system.",
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
                                            value = "Evaluation 1 was deleted",
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
                                                    " \"message\" : \"Evaluation with ID  2 not found\"}"
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
                                                    " \"message\" : \"Evaluation ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<String> deleteEvaluation(@PathVariable Long id);

    @Operation(
            summary = "find All Evaluations By Employee Id",
            description = "This method returns all evaluations assigned to an employee",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The unique ID of the employee whose evaluations we want to return.",
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
                                            description = "Returns a list of evaluations DTOs corresponding to the" +
                                                    " employee of the entered ID.",
                                            value = "["+
                                                    "{" +
                                                    "\"evaluationId\":1," +
                                                    " \"employeeId\" : 2," +
                                                    " \"qualification\" : 50," +
                                                    " \"comment\" : \"Did not meet the project requirements.\"," +
                                                    " \"evaluationDate\" : \"2024-10-05\"" +
                                                    "},"+
                                                    "{" +
                                                    "\"evaluationId\":2," +
                                                    " \"employeeId\" : 2," +
                                                    " \"qualification\" : 90," +
                                                    " \"comment\" : \"Meet project requirements.\"," +
                                                    " \"evaluationDate\" : \"2024-06-15\"" +
                                                    "}"+
                                                    "]"
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
                                                    " \"message\" : \"Evaluation with ID  2 not found\"}"
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
                                                    " \"message\" : \"Evaluation ID cannot be null.\"}"
                                    )
                            )
                    )
            }
    )
    ResponseEntity<List<EvaluationOutputDTO>> findAllEvaluationsByEmployeeId(@PathVariable Long id);
}
