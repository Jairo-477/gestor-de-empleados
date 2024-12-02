package com.gestorempleados.gesto.de.empleados.dto.output;

import com.gestorempleados.gesto.de.empleados.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EvaluationInputDTO {

    private Employee employee;
    private Integer qualification;
    private String comment;
    private LocalDate evaluationDate;

    public EvaluationInputDTO(Employee employee, Integer qualification, String comment, LocalDate evaluationDate) {
        this.employee = employee;
        this.qualification = qualification;
        this.comment = comment;
        this.evaluationDate = evaluationDate;
    }
}
