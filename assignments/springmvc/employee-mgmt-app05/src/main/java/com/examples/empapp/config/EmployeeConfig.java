package com.examples.empapp.config;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeDaoImpl;
import com.examples.empapp.dao.UserDao;
import com.examples.empapp.dao.UserDaoImpl;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.UserService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public EmployeeService employeeService(@Autowired EmployeeDao employeeDao) {
        EmployeeService employeeService = new EmployeeService(employeeDao);
        //employeeService.SetEmployeeDao(employeeDao);
        return employeeService;
    }

    @Bean
    public EmployeeDao employeeDao(@Autowired MysqlDataSource dataSource)
    {       EmployeeDao empDao = new EmployeeDaoImpl(dataSource);

        return empDao;
    }

    @Bean
    public UserDao userDao(@Autowired MysqlDataSource dataSource)
    {       UserDao userDao = new UserDaoImpl(dataSource);

        return userDao;
    }

    @Bean
    public UserService userService(@Autowired UserDao userDao) {
        UserService userService = new UserService(userDao);
        //employeeService.SetEmployeeDao(employeeDao);
        return userService;
    }
    @Bean
    public MysqlDataSource dataSource(){
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName("localhost");
        datasource.setDatabaseName("jdbctraining");
        datasource.setUser("training");
        datasource.setPassword("training");
        return datasource;
    }
}
