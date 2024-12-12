package com.gestorempleados.gesto.de.empleados.repository;

import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {

    @Query("SELECT e FROM Evaluation e WHERE e.employee.id = :id")
    List<Evaluation> findAllEvaluationsByEmployeeId(@Param("id") Long id);
}
