package org.jsp.SpringBootDemo.Exception;

public class InvalidCredentialsException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Inavalid credentials";
	}

}
