package com.example.client.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.client.model.Post;

public interface PostDao extends MongoRepository<Post, String> {

}
