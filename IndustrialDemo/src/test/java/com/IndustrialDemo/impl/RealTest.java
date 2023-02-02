//package com.IndustrialDemo.impl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.IndustrialDemo.Entities.Database.Employee;
//import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;
//import com.IndustrialDemo.Repository.EmployeeRepository;
//import com.IndustrialDemo.Services.ServiceIMPL;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//class RealTest {
//
//	private static final Optional<Employee> Employee = null;
//
//    @MockBean
//	private ServiceIMPL serviceIMPL;
//	
//	@MockBean
//	private EmployeeRepository employeeRepository;
//	
//	
//	@BeforeEach
//	public void setUp() {
//		Optional<com.IndustrialDemo.Entities.Database.Employee> em = Optional.ofNullable(new Employee(123, "abc","fghfg", "986986", "gfhgdh", "gfhgdh", null, null));
//		Mockito.when(employeeRepository.findById(123)).thenReturn(em);
//	}
//	
//	@Test
//	public void getemployeebyid_Success() {
//		String emp_name="abc";
//		RequestDTO dtoById = serviceIMPL.getDtoById(123);
//		assertEquals(emp_name,dtoById.getFirstname());
//	}
//	
//}
