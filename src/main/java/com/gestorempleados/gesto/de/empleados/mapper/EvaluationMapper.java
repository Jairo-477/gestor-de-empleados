package com.gestorempleados.gesto.de.empleados.mapper;

import com.gestorempleados.gesto.de.empleados.dto.input.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import org.springframework.stereotype.Component;

@Component
public class EvaluationMapper {

    public EvaluationOutputDTO toDto(Evaluation evaluation){

        return new EvaluationOutputDTO(
                evaluation.getEmployee(),
                evaluation.getQualification(),
                evaluation.getComment(),
                evaluation.getEvaluationDate()
        );
    }

    public Evaluation toEntity(EvaluationInputDTO evaluationInputDTO){

        return new Evaluation(
                evaluationInputDTO.getEmployee(),
                evaluationInputDTO.getQualification(),
                evaluationInputDTO.getComment(),
                evaluationInputDTO.getEvaluationDate()
        );
    }
}
