package com.module3.SpringDataJPA.repositories;

import com.module3.SpringDataJPA.dto.BloodGroupStats;
import com.module3.SpringDataJPA.dto.CPatientInfo;
import com.module3.SpringDataJPA.dto.IPatientInfo;
import com.module3.SpringDataJPA.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<IPatientInfo> findPatients();

    @Query("select new com.module3.SpringDataJPA.dto.CPatientInfo(p.id as id, p.name as name)" +
            "from PatientEntity p")
    List<CPatientInfo> findBasicInfo();

    @Query("select new com.module3.SpringDataJPA.dto.BloodGroupStats(p.bloodGroup, count(p))" +
            "from PatientEntity p group by p.bloodGroup")
    List<BloodGroupStats> getEachBloodGroupCount();

    @Transactional
    @Modifying
    @Query("update PatientEntity p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("id") Long id, @Param("name") String name);
}















