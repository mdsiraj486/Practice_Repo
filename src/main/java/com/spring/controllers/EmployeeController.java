package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmp() {
		
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.FOUND);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee){
		Employee emp = employeeService.createEmployee(employee);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Employee emp = employeeService.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
	}

}
