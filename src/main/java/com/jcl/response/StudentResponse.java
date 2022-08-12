package com.jcl.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
}
