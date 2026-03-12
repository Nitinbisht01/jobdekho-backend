package com.example.client.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.constants.Apiconstants;
import com.example.client.dto.PostDTO;
import com.example.client.model.Post;
import com.example.client.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {
	
	
	final PostService postService;
	
	@PostMapping(Apiconstants.SAVE_POST)
	public Post savePost(@Valid  @RequestBody PostDTO post) {
	
		log.info("saving post");
		
		return postService.savePost(post);
	}

	@GetMapping(Apiconstants.SAVE_POST)
	public List<Post>getAllPosts(){
		log.info("Getting all posts");
		return this.postService.getAllPosts();
	}
}
