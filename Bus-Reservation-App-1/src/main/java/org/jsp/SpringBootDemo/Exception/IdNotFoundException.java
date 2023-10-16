package org.jsp.SpringBootDemo.Exception;

import javax.print.DocFlavor.READER;

public class IdNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Id Not Found";
	}

}
