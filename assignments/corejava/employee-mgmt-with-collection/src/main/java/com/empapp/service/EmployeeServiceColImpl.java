package com.empapp.service;
import com.empapp.model.Employee;
import com.empapp.exception.EmployeeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class EmployeeServiceColImpl implements EmployeeService {
    int size =0;
    int empIdCount = 1;
   private Map<Integer,Employee> empMap = new HashMap<>();


    @Override
    public boolean create(Employee emp) {
        emp.setEmpID(empIdCount++);
        empMap.put(emp.getEmpID(), emp);
        return true;
    }

    @Override
    public boolean update(Employee emp) {
       empMap.replace((emp.getEmpID()), emp);
        return true;
    }

    @Override
    public boolean delete(int empId) throws EmployeeException {
        Employee empDel = empMap.remove(empId);
        if (empDel != null) {
            return true;
        } else {
            throw new EmployeeException("Employee not in the list ");
        }
    }


    @Override
    public Employee get(int empID) throws EmployeeException {
        Employee emp = findByEmpId(empID);
        if (emp == null)
            throw new EmployeeException("Employee does not exist");
        return emp;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> empList = new ArrayList(empMap.values());
        return empList;
    }

    public Employee findByEmpId(int empId) throws EmployeeException {
        Employee emp = empMap.get(empId);
        if (emp == null) {
            throw new EmployeeException("This employee does not exist");
        } else {
            return emp;
        }
    }

}

