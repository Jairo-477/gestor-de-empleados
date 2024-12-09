package com.gestorempleados.gesto.de.empleados.service;

import com.gestorempleados.gesto.de.empleados.dto.input.EvaluationOutputDTO;
import com.gestorempleados.gesto.de.empleados.dto.output.EvaluationInputDTO;
import com.gestorempleados.gesto.de.empleados.mapper.EvaluationMapper;
import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import com.gestorempleados.gesto.de.empleados.repository.EvaluationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService{

    private final EvaluationRepository evaluationRepository;
    private final EvaluationMapper evaluationMapper;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper){
        this.evaluationRepository = evaluationRepository;
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public EvaluationOutputDTO createEvaluation(EvaluationInputDTO evaluationInputDTO) {

        Evaluation evaluation = evaluationMapper.toEntity(evaluationInputDTO);
        evaluationRepository.save(evaluation);

        return evaluationMapper.toDto(evaluation);
    }

    @Override
    public List<EvaluationOutputDTO> getAllEvaluations(Sort sort) {

        if (sort == null){
            throw new IllegalArgumentException("Sort parameter cannot be null.");
        }

        List<Evaluation> evaluations = evaluationRepository.findAll(sort);

        return evaluations.stream()
                .map(evaluationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EvaluationOutputDTO getEvaluation(Long id) {

        if (id == null){
            throw new IllegalArgumentException("Evaluation ID cannot be null.");
        }

        return evaluationRepository.findById(id)
                .map(evaluationMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Evaluation with id " + id + " not found"));
    }

    @Override
    public EvaluationOutputDTO patchEvaluation(Long id, EvaluationInputDTO evaluationInputDTO) {

        if (id == null){
            throw new IllegalArgumentException("Evaluation ID cannot be null.");
        }
        if (evaluationInputDTO == null){
            throw new IllegalArgumentException("Project input data cannot be null.");
        }

        Evaluation existingEvaluation = evaluationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Evaluation with ID " + id + " not found"));

        if (evaluationInputDTO.getEmployee() != null) {
            existingEvaluation.setEmployee(evaluationInputDTO.getEmployee());
        }
        if (evaluationInputDTO.getQualification() != null){
            existingEvaluation.setQualification(evaluationInputDTO.getQualification());
        }
        if (evaluationInputDTO.getComment() != null){
            existingEvaluation.setComment(evaluationInputDTO.getComment());
        }
        if (evaluationInputDTO.getEvaluationDate() != null){
            existingEvaluation.setEvaluationDate(evaluationInputDTO.getEvaluationDate());
        }

        evaluationRepository.save(existingEvaluation);

        return evaluationMapper.toDto(existingEvaluation);
    }

    @Override
    public void deleteEvaluation(Long id) {

        if (id == null){
            throw new IllegalArgumentException("Evaluation ID cannot be null.");
        }

        if (!evaluationRepository.existsById(id)){
            throw new EntityNotFoundException("Evaluation with ID " + id + " not found");
        }

        evaluationRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> findAllEvaluationsByEmployeeId(Long id) {

        if (id == null){
            throw new IllegalArgumentException("Evaluation ID cannot be null.");
        }

        if (!evaluationRepository.existsById(id)){
            throw new EntityNotFoundException("Evaluation with ID " + id + " not found");
        }

        return evaluationRepository.findAllEvaluationsByEmployeeId(id);
    }
}
