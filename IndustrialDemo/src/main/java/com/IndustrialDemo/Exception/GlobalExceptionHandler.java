package com.IndustrialDemo.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiResponse> employeeNotFoundException(EmployeeNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse ar = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(ar,HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentExceptionHandler(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error-> { //error binding kari badhi error medvani
			//pachi error ni for eah loop ma fervi ne teni field sathe message lay aavvo
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			//now map ma key and value nakhvi
			resp.put(field, message);
			
		}	));
		return new ResponseEntity<Map<String,String>> (resp,HttpStatus.BAD_REQUEST);
		 
	}
}
