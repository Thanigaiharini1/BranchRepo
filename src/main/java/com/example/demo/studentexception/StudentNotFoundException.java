package com.example.demo.studentexception;
public class StudentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1;
	private String message;
	@Override
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public StudentNotFoundException() {
    }
}