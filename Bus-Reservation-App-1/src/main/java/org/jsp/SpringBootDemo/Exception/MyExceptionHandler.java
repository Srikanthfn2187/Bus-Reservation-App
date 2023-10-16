package org.jsp.SpringBootDemo.Exception;

import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler  extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleId(IdNotFoundException e)
	{
		ResponseStructure structure=new ResponseStructure<>();
		structure.setData(" No details Found");
		structure.setMessage(e.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new  ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handlecredentials(InvalidCredentialsException e)
	{
		ResponseStructure structure=new ResponseStructure<>();
		structure.setData("No Data Found");
		structure.setMessage(e.getMessage());
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new  ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
}