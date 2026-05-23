package com.module3.SpringDataJPA.repositories;

import com.module3.SpringDataJPA.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
