package com.examples.empapp.dao;

import com.examples.empapp.model.Employee;
import com.examples.empapp.model.User;

import java.util.List;

public interface UserDao {
    public boolean create(User user);
    public User get(String UserName);
   // public List<Employee> getAll();
}
