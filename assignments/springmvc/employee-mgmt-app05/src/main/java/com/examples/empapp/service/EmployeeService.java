package com.examples.empapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.examples.empapp.controller.EmployeeController;
import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	private EmployeeDao employeeDao;
	private static Map<String, Employee> employees = new LinkedHashMap<String, Employee>();

	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao =employeeDao;
	}



	public void add(Employee employee)
	{


		//employees.put(employee.getId(), employee);
		employeeDao.create(employee);
	}
	
	public void update(Employee employee)
	{
		//employees.put(employee.getId(), employee);
		employeeDao.update(employee);
	}
	
	public Employee get(int empId)
	{
		return employeeDao.get(empId);
	}
	
	public void delete(int empId)
	{
		employees.remove(empId);
		employeeDao.delete(empId);
	}	
	
	public List<Employee> list()
	{
		logger.info("inside employee service");
		return employeeDao.getAll();
	}	
	
}
