package com.gestorempleados.gesto.de.empleados.controller;

import com.gestorempleados.gesto.de.empleados.dto.input.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationInputDTO;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.repository.EvaluationRepository;
import com.gestorempleados.gesto.de.empleados.service.EvaluationService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationRestController {

    private final EvaluationService evaluationService;

    public EvaluationRestController(EvaluationService evaluationService){
        this.evaluationService = evaluationService;
    }

    @PostMapping
    ResponseEntity<EvaluationOutputDTO> createEvaluation (@RequestBody EvaluationInputDTO evaluationInputDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(evaluationService.createEvaluation(evaluationInputDTO));
    }

    @GetMapping
    public ResponseEntity<List<EvaluationOutputDTO>> getAllEvaluations(Sort sort){

        return ResponseEntity.ok(evaluationService.getAllEvaluations(sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationOutputDTO> getEvaluation(@PathVariable Long id){

        return ResponseEntity.ok(evaluationService.getEvaluation(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EvaluationOutputDTO> patchEvaluation(@PathVariable Long id, @RequestBody EvaluationInputDTO evaluationInputDTO){

        return ResponseEntity.ok(evaluationService.patchEvaluation(id, evaluationInputDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvaluation(@PathVariable Long id){

        evaluationService.deleteEvaluation(id);
        return ResponseEntity.ok("Evaluation " + id + " was deleted");
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<Evaluation>> findAllEvaluationsByEmployeeId(@PathVariable Long id) {

        return ResponseEntity.ok(evaluationService.findAllEvaluationsByEmployeeId(id));
    }
}
