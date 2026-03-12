package com.example.client.service;

import java.util.List;

import com.example.client.dto.PostDTO;
import com.example.client.model.Post;

public interface PostService {
	public Post savePost(PostDTO postDTO) ;
		
	public List<Post> getAllPosts();

}
