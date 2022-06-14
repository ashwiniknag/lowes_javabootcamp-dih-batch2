package com.empapp.dao;

import com.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
@Qualifier("empDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    DataSource dataSource;

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    // inserted using constructor injection.
    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
  /*      try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection created successfully " + conn);
    }*/

    /*public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                logger.error("Error occurred while closing the DB Connection - " + e);
            }
        }
    }*/
    @Override
    public Employee create(Employee emp) {
        try {

           conn = dataSource.getConnection();
            stmt = conn.createStatement();

            String query = "INSERT INTO employee3 (name,age,designation,department,country) VALUES(\""
                    + emp.getEmpName() + "\"," + emp.getAge() + ",\"" + emp.getDesignation() + "\",\""
                    + emp.getDepartment() + "\",\"" + emp.getCountry()  + "\")";
            logger.info("insert query" + query);
            stmt.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
    @Override
    public Employee update(Employee emp){
        try {
           conn = dataSource.getConnection();
            stmt = conn.createStatement();

            String query = "UPDATE employee3 SET name = \"" + emp.getEmpName() + "\", age = " + emp.getAge()
                    + " ,designation = \"" + emp.getDesignation() + "\" ,department = \"" + emp.getDepartment()
                    + "\",country=\"" + emp.getCountry()  + "\" WHERE id = "
                    + emp.getEmpID();
            stmt.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    return emp;
    }
    @Override
    public void delete(int empID){
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM employee3 WHERE id = " + empID;
            stmt.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Employee get(int empID) {
        Employee emp = null;
        String query = "SELECT * FROM employee3 WHERE id = " + empID;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");

                emp = new Employee(id, name, age, designation, department, country);

            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("This employee does not exist!");
        }
    return emp;
    }
    @Override
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee3");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");

                employees.add(new Employee(id, name, age, designation, department, country));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;

    }


}
