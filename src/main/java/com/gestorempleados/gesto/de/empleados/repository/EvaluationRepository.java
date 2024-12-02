package com.gestorempleados.gesto.de.empleados.repository;

import com.gestorempleados.gesto.de.empleados.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
