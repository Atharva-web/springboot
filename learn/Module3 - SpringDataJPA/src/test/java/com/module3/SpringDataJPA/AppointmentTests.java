package com.module3.SpringDataJPA;

import com.module3.SpringDataJPA.entities.AppointmentEntity;
import com.module3.SpringDataJPA.service.AppointmentService;
import com.module3.SpringDataJPA.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.time.LocalDateTime;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
public class AppointmentTests {
    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @Test
    public void makeAppointment() {
        // create appointment
        AppointmentEntity appointment = AppointmentEntity.builder()
        .appointmentTime(LocalDateTime.now())
        .build();

        appointmentService.makeAppointment(appointment, 1L, 6L);
    }

    @Test
    public void deleteAppointment() {
//        delete appointment when patient is deleted
        System.out.println(patientService.deletePatient(6L));
    }
}
