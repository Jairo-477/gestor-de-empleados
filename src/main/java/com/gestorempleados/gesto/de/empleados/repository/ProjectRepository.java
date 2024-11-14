package com.gestorempleados.gesto.de.empleados.repository;

import com.gestorempleados.gesto.de.empleados.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
