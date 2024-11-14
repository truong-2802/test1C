package com.example.testc.controller;


import com.example.testc.entity.Applicant;
import com.example.testc.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/applicants/create")
    public String showForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicants/form";
    }

    @PostMapping("/applicants")
    public String submitForm(Applicant applicant) {
        applicantService.saveApplicant(applicant);
        return "redirect:/applicants/list";
    }

    @GetMapping("/applicants/list")
    public String listApplicants(Model model) {
        model.addAttribute("applicants", applicantService.getAllApplicants());
        return "applicants/list";
    }
}