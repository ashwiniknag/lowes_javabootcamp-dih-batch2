package com.lowes.empapp.service;

import com.lowes.empapp.controller.EmployeeController;
import com.lowes.empapp.exception.EmployeeException;
import com.lowes.empapp.model.Employee;
import com.lowes.empapp.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee create(Employee emp) throws EmployeeException {
		return repo.save(emp);
		
	}

	@Override
	public List<Employee> list() throws EmployeeException {
		
		return repo.findAll();
	}

	@Override
	public Employee get(int id) throws EmployeeException {
		Optional<Employee> optional = repo.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			logger.error("Employee not found for the given id " + id);
			throw new EmployeeException(" Employee not found for id :: " + id);
		}
		return employee;
	}
	
	@Override
	public Employee update(int id, Employee employee) throws EmployeeException {
		if(get(id) !=null)
		return repo.save(employee);
		else
			logger.error("Employee not found for the given id " + id);
			throw new EmployeeException(" Employee not found for id :: " + id);
	}

	@Override
	public void delete(int id) throws EmployeeException {
		if(get(id) !=null)
		repo.deleteById(id);
			
	}


}
