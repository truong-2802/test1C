package com.example.testc.repository;

import com.example.testc.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
