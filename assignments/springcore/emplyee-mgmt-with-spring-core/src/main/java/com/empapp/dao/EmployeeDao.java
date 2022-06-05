package com.empapp.dao;
import com.empapp.model.Employee;
import java.util.List;
public interface EmployeeDao {

    public boolean create(Employee emp);

    public boolean update(Employee emp);

    public boolean delete(int empID);

    public Employee get(int empID);

    public List<Employee> getAll();

}
