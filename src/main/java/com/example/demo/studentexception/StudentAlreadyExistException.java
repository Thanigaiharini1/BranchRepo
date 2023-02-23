package com.example.demo.studentexception;
public class StudentAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;


	public  StudentAlreadyExistException()
	{
		super("Student already Exist");
	}
	
	

}
