package com.lowes.empapp.service;

import java.util.List;

import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;

public interface EmployeeService {
	
	public Employee create(Employee emp) throws EmployeeException;
	public List<Employee> list() throws EmployeeException;
	public Employee get(int id) throws EmployeeException;
	public Employee update(int id, Employee emp) throws EmployeeException;
	public void delete(int id) throws EmployeeException;

}
