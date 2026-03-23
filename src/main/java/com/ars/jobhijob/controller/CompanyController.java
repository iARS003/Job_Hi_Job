package com.ars.jobhijob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ars.jobhijob.entity.Company;
import com.ars.jobhijob.entity.Job;
import com.ars.jobhijob.service.CompanyService;
import com.ars.jobhijob.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyController 
{
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;
    @GetMapping("/company/home")
    public String home()
    {
        return "/company/company_home.jsp"; 
    }

    @GetMapping("/company/addJob")
    public String addJob()
    {
        return "/company/add_job.jsp"; 
    }
    
    @PostMapping("/company/addJob")
    public String saveJob(Job job, HttpSession session)
    {
        Company company = (Company) session.getAttribute("company");

        System.out.println("Company: " + company); 
        System.out.println("All session attributes: " + java.util.Collections.list(session.getAttributeNames()));
        if (company == null)
        {
            return "redirect:/company/company_home.jsp";
        }

        job.setCompany(company);
        jobService.saveJob(job);

        return "redirect:/company/viewJobs";
    }
    
    @GetMapping("/company/viewJobs")
    public String viewJobs(Model model, HttpSession session)
    {
        Company company = (Company) session.getAttribute("company");

        if (company == null)
        {
            return "redirect:/company/company_home.jsp";
        }

        // Fetch fresh from DB instead of calling company.getJobs()
        List<Job> jobs = jobService.getJobsByCompany(company.getCom_id());
        model.addAttribute("jobs", jobs);

        return "/company/view_jobs.jsp";
    }
    @GetMapping("/company/editJob")
    public String editJob(@RequestParam int id, Model model)
    {
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "/company/edit_job.jsp";
    }

    @PostMapping("/company/updateJob")
    public String updateJob(Job job, HttpSession session)
    {
        Company company = (Company) session.getAttribute("company");

        if (company == null)
        {
            return "redirect:/login";
        }

        job.setCompany(company);
        jobService.updateJob(job);

        return "redirect:/company/viewJobs";
    }

    @GetMapping("/company/deleteJob")
    public String deleteJob(@RequestParam int id)
    {
        jobService.deleteJob(id);
        return "redirect:/company/viewJobs";
    }
    
   

    @GetMapping("/company/editCompany")
    public String editCompany(HttpSession session, Model model)
    {
        Company company = (Company) session.getAttribute("company");

        if (company == null)
        {
            return "redirect:/login";
        }

        model.addAttribute("company", company);
        return "/company/edit_company.jsp";
    }

    @PostMapping("/company/editCompany")
    public String updateCompany(HttpSession session,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String phone_no)
    {
        Company company = (Company) session.getAttribute("company");

        if (company == null)
        {
            return "redirect:/login";
        }

        company.setName(name);
        company.setEmail(email);
        company.setPhone_no(phone_no);

        Company updated = companyService.updateCompany(company);
        session.setAttribute("company", updated); // update session too

        return "redirect:/company/home";
    }
    
}