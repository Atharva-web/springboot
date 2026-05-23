package com.college.college_mgmt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "admission_record")
public class AdmissionRecord {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer admissionNumber;

    @Column(nullable = false)
    private LocalDateTime admissionDateTime;

    @ManyToOne
    @JoinColumn
    private Program programId;

    private Integer year;

    @Column(nullable = false)
    private Integer fees;

    @ManyToOne
    @JoinColumn
    private Student studentId;
}
