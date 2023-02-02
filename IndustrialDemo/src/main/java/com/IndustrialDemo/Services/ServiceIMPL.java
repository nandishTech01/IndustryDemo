package com.IndustrialDemo.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IndustrialDemo.Entities.Database.Address;
import com.IndustrialDemo.Entities.Database.Department;
import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;
import com.IndustrialDemo.Exception.EmployeeNotFoundException;
import com.IndustrialDemo.MongoRepository.EmployeeMongoRepotory;
import com.IndustrialDemo.Repository.AddressRepository;
import com.IndustrialDemo.Repository.DepartmentRepository;
import com.IndustrialDemo.Repository.EmployeeRepository;

@Service
public class ServiceIMPL implements Services{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMongoRepotory employeeMongoRepotory;
	
//	@Autowired
//	private AddressRepository addressrepository;
//	
//	@Autowired
//	private DepartmentRepository departmentRepository;
	
	@Autowired	
	private ModelMapper modelmapper;
	
	

//	public ServiceIMPL(EmployeeRepository employeeRepository, AddressRepository addressrepository,
//			DepartmentRepository departmentRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//		this.addressrepository = addressrepository;
//		this.departmentRepository = departmentRepository;
//	}

	
	
	public RequestDTO create(RequestDTO rdt) {
		Employee employee = new Employee();
		return rdt;
	}
	

	public ServiceIMPL(EmployeeRepository employeeRepository, EmployeeMongoRepotory employeeMongoRepotory) {
	super();
	this.employeeRepository = employeeRepository;
	this.employeeMongoRepotory = employeeMongoRepotory;
}

	public ServiceIMPL(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> getallEmployees() {
		return employeeRepository.findAll();
	}
	
	

//	public RequestDTO getuserbyid(Integer userId) {
//		Employee employee = employeeRepository.findById(userId)
//				.orElseThrow(()-> new EmployeeNotFoundException("Employee","id",userId ));
//		return this.saveData(employee);
//	}
	
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
		
	}	

	public void saveData(RequestDTO requestDTO) {
		Employee emp = Employee.builder()
				.firstname(requestDTO.getFirstname())
				.lastname(requestDTO.getLastname())
				.code(requestDTO.getCode())
				.mobile(requestDTO.getMobile())
				.build();
		
		Address add = Address.builder()
				.address(requestDTO.getAddress())
				.employee(emp)
				.build();
		//addressrepository.save(add);
		
		
		Department dept = Department.builder()
				.Subdepartment(requestDTO.getSubdepartment())
				.departmentname(requestDTO.getDepartment())
				.employee(emp)//0 - id
				.build();

		//departmentRepository.save(dept);
		
		Set<Department> departmentSet = new HashSet();
		departmentSet.add(dept);
		
		Set<Address> addressset = new HashSet<>();
		addressset.add(add);
		
		emp.setAddress(addressset);
		emp.setDepartment(departmentSet);
		Employee e  = employeeRepository.save(emp);//id
		
		com.IndustrialDemo.Entities.MongoDB.Employee em = new com.IndustrialDemo.Entities.MongoDB.Employee();
		em.setData(requestDTO);
		
		com.IndustrialDemo.Entities.MongoDB.Employee emp1= employeeMongoRepotory.save(em);


		   emp.setRefId(emp1.getid());
	
		Employee save = employeeRepository.save(emp);
		

	}


	@Override
	public RequestDTO createDto(RequestDTO rdt) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RequestDTO getDtoById(Integer dtoId) {
		
		Employee emp = this.employeeRepository.findById(dtoId).orElseThrow(()->new EmployeeNotFoundException("User", "Id", dtoId));
		
		return this.usertodto(emp);
	}


	private Employee dtotoemployee(RequestDTO requestDTO){
		
		Employee emp = Employee.builder()
				.firstname(requestDTO.getFirstname())
				.lastname(requestDTO.getLastname())
				.code(requestDTO.getCode())
				.mobile(requestDTO.getMobile())
				.build();
		return emp;
			
	}
	
	public RequestDTO usertodto(Employee emp) {
		RequestDTO rdt = RequestDTO.builder()
				.firstname(emp.getFirstname())
				.lastname(emp.getLastname())
				.code(emp.getCode())
				.mobile(emp.getMobile())
				.build();
		return rdt;
	}


	
	public List<com.IndustrialDemo.Entities.MongoDB.Employee> getallEmployeesMongo() {
		return employeeMongoRepotory.findAll();
	}


	
	public com.IndustrialDemo.Entities.MongoDB.Employee createempmongo(
			com.IndustrialDemo.Entities.MongoDB.Employee emp) {
		return employeeMongoRepotory.save(emp);
	}


	public ServiceIMPL() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	}


