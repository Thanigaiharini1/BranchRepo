package com.example.demo.studentexception;
public class StudentAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//private static final long serialVersionUID = 1;

	public  StudentAlreadyExistException(int id)
	{
		super("Student already Exist");
	}
	
	

}
