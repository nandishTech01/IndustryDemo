package com.IndustrialDemo.Entities.Database;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String mobile;
	
	private String code;

	@DocumentReference
	private String refId;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL) 
	private Set<Address> address;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private Set<Department> department;

//	public String setRefId(String string) {
//		// TODO Auto-generated method stub
//		return "";
//	}
	
	
	
}
