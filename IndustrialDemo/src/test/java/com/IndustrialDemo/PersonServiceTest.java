package com.IndustrialDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.IndustrialDemo.Repository.EmployeeRepository;
import com.IndustrialDemo.Services.ServiceIMPL;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	@Mock //it will create the mock repo
	private EmployeeRepository employeeRepository;

	private ServiceIMPL impl;

	@BeforeEach  //we can use this for the autowired(mapped) mock employeerrepository with the serviceimpl.
	void setUp() {
		this.impl = new ServiceIMPL(this.employeeRepository);
	}

	@Test	
	void getallEmployees() {
		impl.getallEmployees();
		verify(employeeRepository).findAll();
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearing down...");
		employeeRepository.deleteAll();
	}

}
