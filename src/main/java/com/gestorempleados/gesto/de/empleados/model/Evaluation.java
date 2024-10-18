package com.gestorempleados.gesto.de.empleados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "evaluations")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Employee employee;

    @Column(nullable = false)
    private int calification;

    @Column(nullable = false)
    private String comment;

    @Column(name = "evaluacion_date", unique = true)
    private LocalDate evaluationDate;

    public Evaluation(Employee employee, int calification, String comment, LocalDate evaluationDate) {
        this.employee = employee;
        this.calification = calification;
        this.comment = comment;
        this.evaluationDate = evaluationDate;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", employee=" + employee +
                ", calification=" + calification +
                ", comment='" + comment + '\'' +
                ", evaluationDate=" + evaluationDate +
                '}';
    }
}
