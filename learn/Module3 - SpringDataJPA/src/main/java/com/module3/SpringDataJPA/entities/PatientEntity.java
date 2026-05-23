package com.module3.SpringDataJPA.entities;

import com.module3.SpringDataJPA.enums.BloodGroups;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroups bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true) // owns
    private InsuranceEntity insuranceEntity;

    @OneToMany(mappedBy = "patientEntity", cascade = CascadeType.ALL) // inverse side (mirrors)
    private Set<AppointmentEntity> appointmentEntities = new HashSet<>();
}
