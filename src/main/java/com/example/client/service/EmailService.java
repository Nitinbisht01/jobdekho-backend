package com.example.client.service;

import java.io.File;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // EMAIL TO RECRUITER
    public void sendRecruiterEmail(
            String recruiterEmail,
            String name,
            String profile,
            String experience,
            String portfolio,
            String resumePath) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        helper.setTo(recruiterEmail);
        helper.setSubject("New Job Application for " + profile);

        String content =
                "Candidate Name: " + name + "\n" +
                "Experience: " + experience + "\n" +
                "Portfolio: " + portfolio;

        helper.setText(content);

        File resume = new File(resumePath);
        helper.addAttachment(resume.getName(), resume);

        mailSender.send(message);
    }


    // CONFIRMATION EMAIL TO APPLICANT
    public void sendApplicantConfirmation(
            String applicantEmail,
            String name,
            String profile) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        helper.setTo(applicantEmail);

        helper.setSubject("Application Received - " + profile);

        String content =
                "Hello " + name + ",\n\n" +
                "Thank you for applying for the position of " + profile + ".\n\n" +
                "Your application has been successfully received and forwarded to the recruiter.\n\n" +
                "If shortlisted, the recruiter will contact you.\n\n" +
                "Best Regards,\n" +
                "JobDekho Team";

        helper.setText(content);

        mailSender.send(message);
    }
}