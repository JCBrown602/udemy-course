package com.jcl.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

	// private Long id;

	@JsonProperty("first_name")
	@NotBlank(message = "First name is required.")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("user_email")
	private String email;
}
