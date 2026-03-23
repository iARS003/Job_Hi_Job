package com.ars.jobhijob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ars.jobhijob.entity.Company;
import com.ars.jobhijob.entity.JobSeeker;
import com.ars.jobhijob.entity.User;
import com.ars.jobhijob.service.CompanyService;
import com.ars.jobhijob.service.JobSeekerService;
import com.ars.jobhijob.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController
{
    @Autowired
    public UserService services;

    @Autowired
    public CompanyService com_services;

    @Autowired
    public JobSeekerService jobSeekerService;  

    @GetMapping("/")
    public String home()
    {
        return "user/index.jsp";
    }

    @GetMapping("/register")
    public String showRegister()
    {
        return "user/register.jsp";
    }

    @PostMapping("/register")
    public String register(User user)
    {
        services.register(user);

        if ("COMPANY".equals(user.getRole()))
        {
            Company company = new Company();
            company.setName(user.getName());
            company.setEmail(user.getEmail());
            company.setUser(user);
            com_services.saveCompany(company);
        }
        else if ("JOB_SEEKER".equals(user.getRole()))  
        {
            JobSeeker js = new JobSeeker();
            js.setName(user.getName());
            js.setEmail(user.getEmail());
            js.setUser(user);
            jobSeekerService.save(js);
        }

        return "user/login.jsp";
    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "user/login.jsp";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session)
    {
        User u = services.login(username, password);
        if (u != null)
        {
            if (u.getRole().equals("COMPANY"))
            {
                Company company = com_services.getByUser(u);
                session.setAttribute("company", company);
                return "redirect:/company/home";
            }
            else if (u.getRole().equals("JOB_SEEKER"))
            {
                JobSeeker js = jobSeekerService.getByUser(u.getId());  
                session.setAttribute("jobSeeker", js);                 
                return "redirect:/jobseeker/home";                     
            }
        }
        return "/user/login.jsp";
    }

    @GetMapping("/forgot")
    public String showForgot()
    {
        return "user/forgot.jsp";
    }

    @PostMapping("/forgot")
    public String forgotPassword(@RequestParam String username, @RequestParam String password)
    {
        User u = services.findByUsername(username);
        if (u != null)
        {
            u.setPassword(password);
            services.updatePassword(u);
            return "user/login.jsp";
        }
        return "user/forgot.jsp";
    }
}