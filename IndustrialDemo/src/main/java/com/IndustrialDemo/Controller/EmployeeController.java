package com.IndustrialDemo.Controller;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;
import com.IndustrialDemo.Services.ServiceIMPL;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceIMPL impl;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/create")
	public String info() {
		return "hello world..";
	}
	
//	@GetMapping("/employees")
//	public List<Employee> getEmployees(){
//		return impl.getallEmployees()
//		
//	}
	
	@PostMapping(value = "/employee")
	public ResponseEntity<RequestDTO> addEmployee(@Valid @RequestBody RequestDTO rdt) {
		impl.saveData(rdt);
		return new ResponseEntity<RequestDTO>(HttpStatus.OK);
	}
	
	
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<RequestDTO> getsingleuser(@PathVariable Integer eid){
		return ResponseEntity.ok(this.impl.getDtoById(eid));
	}
	
}
