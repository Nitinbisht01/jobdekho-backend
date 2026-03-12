package com.example.client.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "applications")
public class JobApplication {

    @Id
    private String id;

    private String profile;
    
    private String name;
    private String email;
    private String gender;
    private String experience;
    private String portfolio;

    private String resumePath;  // path of stored file

    @CreatedDate
    @Field("applied_at")
    private Date appliedAt;
}