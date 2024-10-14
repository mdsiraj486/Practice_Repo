package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
