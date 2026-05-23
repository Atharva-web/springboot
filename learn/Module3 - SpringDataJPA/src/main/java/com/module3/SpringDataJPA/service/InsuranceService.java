package com.module3.SpringDataJPA.service;

import com.module3.SpringDataJPA.entities.InsuranceEntity;
import com.module3.SpringDataJPA.entities.PatientEntity;
import com.module3.SpringDataJPA.repositories.InsuranceRepository;
import com.module3.SpringDataJPA.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public void assignInsuranceToPatient(InsuranceEntity insuranceEntity, Long patientId) {
        System.out.println("inside assign insurance to patient");

//        insuranceRepository.save(insuranceEntity); persistent state
//        rather than manually db operations, cascade the operations

        PatientEntity patientEntity = patientRepository
                .findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        patientEntity.setInsuranceEntity(insuranceEntity);
        insuranceEntity.setPatientEntity(patientEntity);

        patientRepository.save(patientEntity);
    }

}
