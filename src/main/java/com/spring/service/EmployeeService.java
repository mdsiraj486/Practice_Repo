package com.spring.service;

import java.util.List;

import com.spring.entities.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployeeById(Integer id);

}
