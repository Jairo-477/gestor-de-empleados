package com.gestorempleados.gesto.de.empleados.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "proyects")
public class Proyect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @ManyToMany
    @JoinTable(name = "proyect_employee",
            joinColumns = @JoinColumn(name = "proyect_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

    public Proyect(String name, String description, LocalDate registrationDate) {
        this.name = name;
        this.description = description;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Proyect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
