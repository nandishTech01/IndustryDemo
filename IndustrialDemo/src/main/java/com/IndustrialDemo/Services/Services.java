package com.IndustrialDemo.Services;

import java.util.List;
import java.util.Set;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;

public interface Services  {
	
	List<Employee> getallEmployees();
	
	Employee createEmployee(Employee e);
	
	RequestDTO createDto(RequestDTO rdt);
	
    RequestDTO getDtoById(Integer dtoId);
    
    List<com.IndustrialDemo.Entities.MongoDB.Employee> getallEmployeesMongo();
    
    com.IndustrialDemo.Entities.MongoDB.Employee createempmongo(com.IndustrialDemo.Entities.MongoDB.Employee emp);
    
    
//	
//	List<RequestDTO> getalldto();
	

	
	
	
	
}
