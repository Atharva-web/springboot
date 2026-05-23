package com.module3.SpringDataJPA.service;

import com.module3.SpringDataJPA.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public boolean deletePatient(Long patientId) {
        try {
            System.out.println("before");
            patientRepository.deleteById(patientId);
            System.out.println("after");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
