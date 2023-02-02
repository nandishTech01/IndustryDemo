package com.IndustrialDemo.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundException extends RuntimeException{

	String resourseName;
	String fieldname;
	long fieldvalue;
	
	public EmployeeNotFoundException(String resourseName,String fieldname,long fieldvalue) {
		super(String.format("%s not found with %s: %s", resourseName,fieldname,fieldvalue));
		this.resourseName=resourseName;
		this.fieldname=fieldname;
		this.fieldvalue= fieldvalue;
	}
}
