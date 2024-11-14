package com.example.testc.service;

import com.example.testc.entity.JobPost;
import com.example.testc.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {
    @Autowired
    private JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public void saveJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);  // Sẽ tự động cập nhật nếu jobPost có id
    }

    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }

    public Optional<JobPost> getJobPostById(Long id) {
        return jobPostRepository.findById(id);
    }
}
