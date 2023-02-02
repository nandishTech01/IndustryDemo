package com.IndustrialDemo.Entities.RequestDTO;

import com.IndustrialDemo.Annotations.ValidateFirstName;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

	@Column(length = 5)
	@Size(min = 3 ,max = 5, message = "code should have minimum 3 and maximum 5")
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@NotEmpty
	private String code;
	
//	@Column(length = 10)
//	@Size(min = 3 ,max = 10, message = "firstname should have minimum 3 and maximum 10 characters" )
//	@NotEmpty
//	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@ValidateFirstName
	private String firstname;
	
	@Column(length = 10)
	@Size(min = 3 ,max = 10, message = "lastname should have minimum 3 and maximum 10 characters")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@NotEmpty
	private String lastname;
	 
	@Column(length = 100)
	@Size(min = 3 ,max = 100, message = "address should have minimum 3 and maximum 100 character.. ")
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@NotEmpty
	private String address;
	
	@Column(length = 10)
	@Size(min = 10 ,max = 10)
	@Pattern(regexp = "[0-9]+")
	@NotEmpty
	@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	private String mobile;
	
	@Column(length = 10)
	@Size(min = 5 ,max = 10, message = "department should have minimum 3 and maximum 10 ")
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z]*$")
	private String department;
	
	@Column(length = 10)
	@Size(min = 5 ,max = 10, message = "subdepartment should have minimum 3 and maximum  10")
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@NotEmpty
	private String subdepartment;
	
	
		
}
