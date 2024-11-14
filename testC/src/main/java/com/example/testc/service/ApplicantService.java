package com.example.testc.service;

import com.example.testc.entity.Applicant;
import com.example.testc.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public void saveApplicant(Applicant applicant) {
        applicantRepository.save(applicant);
    }
}