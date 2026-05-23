package com.module3.SpringDataJPA;

import com.module3.SpringDataJPA.dto.BloodGroupStats;
import com.module3.SpringDataJPA.dto.CPatientInfo;
import com.module3.SpringDataJPA.dto.IPatientInfo;
import com.module3.SpringDataJPA.entities.PatientEntity;
import com.module3.SpringDataJPA.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getPatientInfo() {
//        List<PatientEntity> patientEntities = patientRepository.findAll();
        List<IPatientInfo> patientInfos = patientRepository.findPatients();
        patientInfos.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getEmail());
        });
    }

    @Test
    public void getBasicInfo() {
        List<CPatientInfo> basicInfos = patientRepository.findBasicInfo();
        basicInfos.forEach(System.out::println);
    }

    @Test
    public void getBloodGroupCount() {
        List<BloodGroupStats> bloodGroupCount = patientRepository.getEachBloodGroupCount();
        bloodGroupCount.forEach(System.out::println);
    }

    @Test
    public void updatePatient() {
        int rowsAffected = patientRepository.updatePatientNameWithId(5L, "Nair Karthik");
        System.out.println(rowsAffected);
    }

    @Test
    @Transactional
    public void findPatient() {
        PatientEntity pe1 = patientRepository.findById(1L).orElseThrow();
        PatientEntity pe2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(pe1 == pe2);
    }
}
