package com.empapp.service;

import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee create(Employee emp) throws EmployeeException;
    public Employee update(int id,Employee emp);
    public void delete(int empId) throws EmployeeException;
    public Employee get(int empId);
    public List<Employee> getAll();
}
