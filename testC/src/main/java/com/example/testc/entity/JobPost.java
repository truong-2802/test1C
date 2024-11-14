package com.example.testc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate IDs
    private Long id;
    private String title;
    private String description;
    private String benefits;
    private String salary;
    private String location;

    // Mối quan hệ One-to-Many giữa JobPost và ApplicantProfile
    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Applicant> applicantProfiles;
}
