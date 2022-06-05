package com.empapp.config;

import com.empapp.dao.EmployeeDao;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.service.EmpServiceSpringCoreImpl;
import com.empapp.service.EmployeeService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

@Bean
    public EmployeeService employeeService(@Autowired EmployeeDao employeeDao) {
    EmpServiceSpringCoreImpl employeeService = new EmpServiceSpringCoreImpl(employeeDao);
    //employeeService.SetEmployeeDao(employeeDao);
    return employeeService;
    }

    @Bean
    public EmployeeDao employeeDao(@Autowired MysqlDataSource dataSource)
    {       EmployeeDaoImpl empDao = new EmployeeDaoImpl(dataSource);

        return empDao;
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
