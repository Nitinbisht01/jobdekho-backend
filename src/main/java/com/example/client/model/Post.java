package com.example.client.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Document(collection = "post")
public class Post {
	@Id
	private String id;
	
	
	@NotNull
	@NotEmpty
private String profile;
	
	@NotNull
	private String type;
	
	@NotNull
	private String description;
	
	@NotNull
	private String experience;
	
	@NotNull
	private String company;
	
	@NotNull
	private String technology[];
	
	@NotNull
	private String salary;

    @CreatedDate
    @Field("created_at")
    private Date createdAt;
    
    @NotNull
    private String email;
}
