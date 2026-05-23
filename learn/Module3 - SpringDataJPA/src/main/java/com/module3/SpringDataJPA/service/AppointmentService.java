package com.module3.SpringDataJPA.service;

import com.module3.SpringDataJPA.entities.AppointmentEntity;
import com.module3.SpringDataJPA.entities.DoctorEntity;
import com.module3.SpringDataJPA.entities.PatientEntity;
import com.module3.SpringDataJPA.repositories.AppointmentRepository;
import com.module3.SpringDataJPA.repositories.DoctorRepository;
import com.module3.SpringDataJPA.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void makeAppointment(AppointmentEntity appointmentEntity, Long doctorId, Long patientId) {
        // find doctor and patient if exists
        DoctorEntity doctorEntity = doctorRepository.findById(doctorId).orElseThrow(() -> new NoSuchElementException("Doctor is not present"));
        PatientEntity patientEntity = patientRepository.findById(patientId).orElseThrow(() -> new NoSuchElementException("Patient is not present"));

        appointmentEntity.setDoctorEntity(doctorEntity);
        appointmentEntity.setPatientEntity(patientEntity);
        appointmentEntity.setReason("CRWAAAZY");

        appointmentRepository.save(appointmentEntity);
    }
}
