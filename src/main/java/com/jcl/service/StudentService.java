package com.jcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jcl.entity.Student;
import com.jcl.repository.StudentRepository;
import com.jcl.request.CreateStudentRequest;
import com.jcl.request.InQueryRequest;
import com.jcl.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		// findAll() is provided by JpaRepository() super
		return studentRepository.findAll();
	}

	public Student createStudent(CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);

		studentRepository.save(student);
		return student;
	}
	
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		Student student = studentRepository.getReferenceById(updateStudentRequest.getId());
		
		// Check first name
		if (updateStudentRequest.getFirstName() != null &&
				!updateStudentRequest.getFirstName().isEmpty()) {
			// Make sure it's capitalized
			//String output = str.substring(0, 1).toUpperCase() + str.substring(1);
			student.setFirstName(updateStudentRequest.getFirstName());
		}
		
		// Check last name
		if (updateStudentRequest.getLastName() != null &&
				!updateStudentRequest.getLastName().isEmpty()) {
			// Make sure it's capitalized
			//String output = str.substring(0, 1).toUpperCase() + str.substring(1);
			student.setLastName(updateStudentRequest.getLastName());
		}
		
		// Check email
		if (updateStudentRequest.getEmail() != null &&
				!updateStudentRequest.getEmail().isEmpty()) {
			// Make sure it's capitalized
			//String output = str.substring(0, 1).toUpperCase() + str.substring(1);
			student.setEmail(updateStudentRequest.getEmail());
		}
		
		// Save values
		student = studentRepository.save(student);
		return student;
	}
	
	public String deleteStudent (long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
	
	public List<Student> getByFirstName (String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
	public Student getByFirstNameAndLastName (String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameOrLastName (String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameIn (InQueryRequest inQueryRequest) {
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}

	public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return studentRepository.findAll(pageable).getContent();
	}
	
	public List<Student> getAllStudentsWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "lastName", "firstName");
		
		return studentRepository.findAll(sort);
	}
}
