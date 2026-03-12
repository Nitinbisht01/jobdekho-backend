package com.example.client.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.client.model.JobApplication;

public interface JobApplicationRepository 
        extends MongoRepository<JobApplication, String> {

}