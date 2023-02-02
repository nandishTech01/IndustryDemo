package com.IndustrialDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Repository.EmployeeRepository;

 
@SpringBootTest
class Employeetest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void isEmployeeById() {
	
		Employee em = new Employee(123, "fghgf","fghfg", "986986", "gfhgdh", "gfhgdh", null, null);
		employeeRepository.save(em);
		boolean actualvalue = employeeRepository.isEmployeeById(1202);
		assertThat(actualvalue).isTrue();
// it will check the the both id that you have to add and check.
	}

}
