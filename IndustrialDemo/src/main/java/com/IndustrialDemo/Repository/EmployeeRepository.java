package com.IndustrialDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IndustrialDemo.Entities.Database.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select case when count(s) > 0 then true else false end from Employee s where s.id= ?1 ")
	boolean isEmployeeById(Integer id);

}
