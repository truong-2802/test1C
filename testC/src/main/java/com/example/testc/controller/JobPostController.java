package com.example.testc.controller;

import com.example.testc.entity.JobPost;
import com.example.testc.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    // Hiển thị form thêm công việc
    @GetMapping("/jobposts/create")
    public String showCreateJobPostForm(Model model) {
        model.addAttribute("jobPost", new JobPost());
        return "jobposts/form"; // Form tạo công việc mới
    }

    // Hiển thị form sửa công việc
    @GetMapping("/jobposts/edit/{id}")
    public String showEditJobPostForm(@PathVariable("id") Long id, Model model) {
        Optional<JobPost> jobPostOptional = jobPostService.getJobPostById(id);
        if (jobPostOptional.isPresent()) {
            model.addAttribute("jobPost", jobPostOptional.get());
            return "jobposts/form"; // Form sửa công việc đã có
        }
        model.addAttribute("errorMessage", "Không tìm thấy tin tuyển dụng");
        return "redirect:/jobposts/list";
    }

    // Xử lý form tạo hoặc sửa công việc
    @PostMapping("/jobposts")
    public String createOrUpdateJobPost(@ModelAttribute JobPost jobPost) {
        if (jobPost.getId() != null) {
            // Nếu có ID, thực hiện cập nhật
            jobPostService.saveJobPost(jobPost);
        } else {
            // Nếu không có ID, thực hiện tạo mới
            jobPostService.saveJobPost(jobPost);
        }
        return "redirect:/jobposts/list";
    }

    // Danh sách các công việc
    @GetMapping("/jobposts/list")
    public String listJobPosts(Model model) {
        model.addAttribute("jobPosts", jobPostService.getAllJobPosts());
        return "jobposts/list";
    }

    // Xóa công việc
    @GetMapping("/jobposts/delete/{id}")
    public String deleteJobPost(@PathVariable("id") Long id) {
        jobPostService.deleteJobPost(id);
        return "redirect:/jobposts/list";
    }
}
