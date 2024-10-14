package com.spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "securitydb" ,name = "emp_tble")
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String empDept;
	private String empAddress;
	private String empEmail;

}
