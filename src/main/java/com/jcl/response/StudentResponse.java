package com.jcl.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jcl.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	@JsonIgnore
	private long id;

	@JsonProperty("First_Name")
	private String firstName;

	@JsonProperty("Last_Name")
	private String lastName;

	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Full_Name")
	private String fullName;

	public StudentResponse(Student student) {
		this.id = student.getIdLong();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.fullName = student.getFirstName() + " " +
				student.getLastName();
	}
}
