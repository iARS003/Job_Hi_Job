package com.ars.jobhijob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ars.jobhijob.entity.Job;
import com.ars.jobhijob.entity.JobSeeker;
import com.ars.jobhijob.service.JobSeekerService;
import com.ars.jobhijob.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobSeekerController
{
    @Autowired private JobSeekerService jobSeekerService;
    @Autowired private JobService jobService;

    @GetMapping("/jobseeker/home")
    public String home(HttpSession session, Model model)
    {
        JobSeeker js = (JobSeeker) session.getAttribute("jobSeeker");
        if (js == null) return "redirect:/login";

        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        model.addAttribute("jobSeeker", js);

        return "/jobseeker/job_seeker_home.jsp";
    }

    @GetMapping("/jobseeker/editProfile")
    public String editProfile(HttpSession session, Model model)
    {
        JobSeeker js = (JobSeeker) session.getAttribute("jobSeeker");
        if (js == null) return "redirect:/login";

        model.addAttribute("jobSeeker", js);
        return "/jobseeker/edit_profile.jsp";
    }

    @PostMapping("/jobseeker/editProfile")
    public String updateProfile(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone_no,
                                @RequestParam String skills,
                                @RequestParam int experience,
                                HttpSession session)
    {
        JobSeeker js = (JobSeeker) session.getAttribute("jobSeeker");
        if (js == null) return "redirect:/login";

        js.setName(name);
        js.setEmail(email);
        js.setPhone_no(phone_no);
        js.setSkills(skills);
        js.setExperience(experience);

        JobSeeker updated = jobSeekerService.update(js);
        session.setAttribute("jobSeeker", updated);

        return "redirect:/jobseeker/home";
    }
    @GetMapping("/jobseeker/apply")
    public String apply(@RequestParam int jobId, HttpSession session)
    {
        JobSeeker js = (JobSeeker) session.getAttribute("jobSeeker");
        if (js == null) return "redirect:/login";

        session.setAttribute("applyMessage", "Applied successfully!");
        return "redirect:/jobseeker/home";
    }
}