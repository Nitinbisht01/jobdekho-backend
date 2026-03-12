package com.example.client.dto;



import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class PostDTO {
	
	private String profile;
	
	private String type;
	
	private String description;
	
	private String experience;
	
	private String technology[];
	
	private String salary;
	
	
	private String company;
	
	private String email;
	
	


}
