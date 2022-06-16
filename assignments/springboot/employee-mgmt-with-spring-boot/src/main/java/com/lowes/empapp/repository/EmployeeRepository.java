package com.lowes.empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.empapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
