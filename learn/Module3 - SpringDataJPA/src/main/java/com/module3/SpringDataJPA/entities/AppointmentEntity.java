package com.module3.SpringDataJPA.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 50)
    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false) // owns
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(nullable = false) // owns
    private DoctorEntity doctorEntity;
}
