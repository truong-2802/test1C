package com.example.testc.repository;

import com.example.testc.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {


}
