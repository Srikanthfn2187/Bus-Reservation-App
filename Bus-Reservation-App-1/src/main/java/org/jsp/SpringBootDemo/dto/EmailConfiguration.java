package org.jsp.SpringBootDemo.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmailConfiguration 
{
	private String to,text,subject;
}
