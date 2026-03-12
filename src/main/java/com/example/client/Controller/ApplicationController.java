package com.example.client.Controller;

import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.client.constants.Apiconstants;
import com.example.client.dao.PostDao;
import com.example.client.dto.JobApplicationDTO;
import com.example.client.model.JobApplication;
import com.example.client.model.Post;
import com.example.client.service.EmailService;
import com.example.client.service.JobApplicationRepository;
import com.example.client.service.PostServiceImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class ApplicationController {

    @Autowired
    private JobApplicationRepository repo;
    @Autowired EmailService emailService;
    
    @Autowired
    PostDao postDao;
    

    @PostMapping(Apiconstants.APPLY_JOBS)
    public JobApplication apply(@ModelAttribute JobApplicationDTO dto) throws Exception {

        MultipartFile file = dto.getResume();

        String uploadDir = "uploads/";
        String fileName = file.getOriginalFilename();

        Path path = Paths.get(uploadDir + fileName);

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        JobApplication app = new JobApplication();

        app.setProfile(dto.getProfile());
        app.setName(dto.getName());
        app.setEmail(dto.getEmail());
        app.setGender(dto.getGender());
        app.setExperience(dto.getExperience());
        app.setPortfolio(dto.getPortfolio());
        app.setResumePath(uploadDir + fileName);

        log.info("saving applicant");
        repo.save(app);
        
        // get recruiter email from Post
        Post post = postDao.findById(dto.getPostId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Job post not found for id: " + app.getProfile()));

        String recruiterEmail = post.getEmail();   // or getRecruiterEmail()

        // send email to recruiter
        emailService.sendRecruiterEmail(
                recruiterEmail,
                dto.getName(),
                dto.getProfile(),
                dto.getExperience(),
                dto.getPortfolio(),
                uploadDir + fileName
        );

        // send confirmation email to applicant
        emailService.sendApplicantConfirmation(
                dto.getEmail(),
                dto.getName(),
                dto.getProfile()
        );
        log.info("sending email");

        return app;
    }
}
  

