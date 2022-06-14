package com.empapp.dao;
import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;
import java.util.List;
public interface EmployeeDao {

    public Employee create(Employee emp);
    public Employee update(Employee emp);
    public void delete(int empID)throws EmployeeException;
    public Employee get(int empID);
    public List<Employee> getAll();

}
