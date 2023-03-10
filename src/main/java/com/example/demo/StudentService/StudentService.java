package com.example.demo.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.StudentEntity.Student;
import com.example.demo.StudentRepositry.StudentRepositry;
import com.example.demo.studentexception.ResourceNotFoundException;
import com.example.demo.studentexception.StudentAlreadyExistException;

@Service
public class StudentService {
	@Autowired
	private StudentRepositry studentRepository;

	public Student addstudent(Student student) {
		if (studentRepository.existsById(student.getId()))
			throw new StudentAlreadyExistException(student.getId());
		else
			return studentRepository.save(student);

	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + id));
	}

	public String updateStudent(Student student, Integer id) {

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id :" + id));
		existingStudent.setName(student.getName());
		existingStudent.setEmailId(student.getEmailId());
		existingStudent.setDepartment(student.getDepartment());
		existingStudent.setLocation(student.getLocation());
		studentRepository.save(existingStudent);
		return "updated Student";
	}

	

	public String deleteStudent(int id)
	{
		Student exist=studentRepository.findById(id).orElse(null);
		if(exist!=null) {
			studentRepository.deleteById(id);return "Deleted Successfully";
		}
		else
		{
			throw new ResourceNotFoundException("Student not exist");
			}
	}
	
}
