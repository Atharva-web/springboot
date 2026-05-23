package com.module3.SpringDataJPA.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false, name = "head_doctor_id")
    private DoctorEntity headDoctor; // head

    @ManyToMany
    private Set<DoctorEntity> doctorEntities = new HashSet<>(); // assigned
}
