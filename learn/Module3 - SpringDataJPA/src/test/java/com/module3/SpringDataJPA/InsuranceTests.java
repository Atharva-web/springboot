//package com.module3.SpringDataJPA;
//
//import com.module3.SpringDataJPA.entities.InsuranceEntity;
//import com.module3.SpringDataJPA.repositories.PatientRepository;
//import com.module3.SpringDataJPA.service.InsuranceService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@SpringBootTest
//public class InsuranceTests {
//    @Autowired
//    private InsuranceService insuranceService;
//
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @Test
//    public void test1() {
////        transient state
//        InsuranceEntity insurance = InsuranceEntity.builder()
//                .provider("HDFC Ergo")
//                .createdAt(LocalDateTime.now())
//                .validUntil(LocalDate.of(2040, 1, 1))
//                .policyNumber("POL001")
//                .build();
//
//
//        insuranceService.assignInsuranceToPatient(insurance, 2L);
//    }
//
//    @Test
//    public void testDeleteCascade() {
//        patientRepository.findById(1L).orElseThrow();
//        patientRepository.deleteById(1L);
//    }
//}
