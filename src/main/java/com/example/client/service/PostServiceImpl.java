package com.example.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.dao.PostDao;
import com.example.client.dto.PostDTO;
import com.example.client.model.Post;
@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	PostDao postDao;
	
	@Override
	public Post savePost(PostDTO postDTO) {
		// TODO Auto-generated method stub
		Post post=new Post();
		
		post.setProfile(postDTO.getProfile());
		post.setDescription(postDTO.getDescription());
		post.setExperience(postDTO.getExperience());
		post.setTechnology(postDTO.getTechnology());
		post.setType(postDTO.getType());
		post.setSalary(postDTO.getSalary());
		post.setEmail(postDTO.getEmail());
		post.setCompany(postDTO.getCompany());
		
		return postDao.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return postDao.findAll();
		
	}

	
}
