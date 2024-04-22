package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO 
{
	private Long id;
	
    private String company;
    
    private String title;
    
    private String type;
    
    private String salary;
    
    private String description;
    
}
