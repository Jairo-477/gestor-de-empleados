package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EvaluationService{

    EvaluationOutputDTO createEvaluation (EvaluationInputDTO evaluationInputDTO);

    List<EvaluationOutputDTO> getAllEvaluations (Sort sort);

    EvaluationOutputDTO getEvaluation (Long id);

    EvaluationOutputDTO patchEvaluation(Long id, EvaluationInputDTO evaluationInputDTO);

    void deleteEvaluation (Long id);

    List<Evaluation> findAllEvaluationsByEmployeeId(Long id);
}
