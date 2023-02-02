package com.IndustrialDemo.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.IndustrialDemo.Entities.Database.Employee;

public interface EmployeeMongoRepotory extends MongoRepository<com.IndustrialDemo.Entities.MongoDB.Employee, Integer>{

}
