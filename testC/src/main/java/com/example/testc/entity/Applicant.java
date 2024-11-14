package com.example.testc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate IDs
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String education;
    private String skillsExperience;

    // Mối quan hệ Many-to-One từ ApplicantProfile đến JobPost
    @ManyToOne
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;
}
