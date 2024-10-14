package com.spring.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.entities.Employee;
import com.spring.exceptions.ResourceNotFoundException;
import com.spring.repo.EmployeeRepository;
import com.spring.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	

	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee Not found with Id : "+id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
				employeeRepository.deleteById(id);
		
	}

}
