package com.gestorempleados.gesto.de.empleados.dto.output;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EvaluationOutputDTO {

    private Long evaluationId;
    private Long employeeId;
    private Integer qualification;
    private String comment;
    private LocalDate evaluationDate;

    public EvaluationOutputDTO(Long evaluationId,Long employeeId, Integer qualification, String comment, LocalDate evaluationDate) {
        this.evaluationId = evaluationId;
        this.employeeId = employeeId;
        this.qualification = qualification;
        this.comment = comment;
        this.evaluationDate = evaluationDate;
    }
}
