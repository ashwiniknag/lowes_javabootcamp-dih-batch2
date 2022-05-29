package com.empapp.service;

import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface EmployeeService {

    public boolean create(Employee emp);
    public boolean update(Employee emp);
    public boolean delete(int empId) throws EmployeeException;
    public Employee get(int empId) throws EmployeeException;
    public List<Employee> getAll();
    public void bulkImport();
    public void bulkExport();

    public boolean validate(Employee emp, String msg, Predicate<Employee> condition,
                            Function<String, Boolean> operation);
}
