package com.empapp.service;

import com.empapp.dao.EmployeeDao;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;
//import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    public EmployeeDaoImpl empDao;

    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        super();
        this.empDao = employeeDao;
    }
    @Override
    public Employee create(Employee emp) throws EmployeeException{
        return empDao.create(emp);
    }
    @Override
    public Employee update(int id, Employee emp) {
        return empDao.update(emp);
    }
    @Override
    public void delete(int empId) throws EmployeeException{
       empDao.delete(empId);
    }
    @Override
    public Employee get(int empId){
        return empDao.get(empId);
    }
    @Override
    public List<Employee> getAll() {
        return empDao.getAll();
    }
}
