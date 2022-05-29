package com.empapp.service;

import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    public boolean create(Employee emp);
    public boolean update(Employee emp);
    public boolean delete(int empId) throws EmployeeException;
    public Employee get(int empId) throws EmployeeException;
    public List<Employee> getAll();
    public void bulkImport();
    public void bulkExport();
}
