package com.example.client.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class JobApplicationDTO {

    @NotBlank
    private String profile;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String gender;

    @NotBlank
    private String experience;
    
    private String postId;

    private String portfolio;

    private MultipartFile resume;   // resume file
    
    
}