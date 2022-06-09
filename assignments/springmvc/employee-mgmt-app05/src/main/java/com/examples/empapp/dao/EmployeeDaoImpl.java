package com.examples.empapp.dao;

import com.examples.empapp.controller.EmployeeController;
import com.examples.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

import com.examples.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.jdbc.support.JdbcUtils.closeConnection;

public class EmployeeDaoImpl implements EmployeeDao{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
        MysqlDataSource datasource = null;
    Connection conn =null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;


    public EmployeeDaoImpl(MysqlDataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public boolean create(Employee emp) {
        boolean status = false;
        try {

            conn = datasource.getConnection();
            stmt = conn.createStatement();

            List<String> skills = emp.getSkills();
            String skillsList = skills.stream()
                    .collect(Collectors.joining(","));

            String query = "INSERT INTO employee2 (name, age,gender,contractor,skills,designation,department,address,country) VALUES(\""
                    + emp.getName() + "\",\"" + emp.getAge() +  "\",\"" + emp.getGender() + "\"," + emp.isContractor() + ",\"" + skillsList  +"\",\""+ emp.getDesignation() + "\",\""
                    + emp.getDepartment() + "\",\"" + emp.getAddress()  +"\",\"" + emp.getCountry()  + "\")";
            logger.info("insert query" + query);
            status = stmt.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    @Override
    public boolean update(Employee emp) {
        boolean status = false;
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();
            List<String> skills = emp.getSkills();
            String skillsList = skills.stream()
                    .collect(Collectors.joining(","));

            String query = "UPDATE employee2 SET name = \"" + emp.getName() + "\", age = " + emp.getAge()
                    + " ,gender = \"" + emp.getGender() + "\" ,contractor = " + emp.isContractor() + " ,skills = \"" + skillsList
                    + "\",designation=\"" + emp.getDesignation()  +"\",department=\"" + emp.getDepartment()  +"\",address=\"" + emp.getAddress()
                    + "\",country=\"" + emp.getCountry()  + "\" WHERE id = "
                    + emp.getId();
            logger.info("update query" + query);
            status = stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return status;

    }


    @Override
    public boolean delete(int empId) {
        boolean status = false;
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();

            String query = "DELETE FROM employee2 WHERE id = " + empId;
            status = stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    @Override
    public Employee get(int empId) {
          Employee emp = null;
            String query = "SELECT * FROM employee2 WHERE id =  '"+ empId + "'";
            try {
                conn = datasource.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    boolean contractor = rs.getBoolean("contractor");
                    String skillvalue = rs.getString("skills");
                    List<String> skills = Arrays.asList(skillvalue.split(","));
                    String designation = rs.getString("designation");
                    String department = rs.getString("department");
                    String address = rs.getString("address");
                    String country = rs.getString("country");

                    emp = new Employee(id,name, age,gender,contractor,skills,designation,department,address, country);

                }

            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println("This employee does not exist!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return emp;
        }

    @Override
    public List<Employee> getAll() {
        logger.info("inside emp Dao impl");
        List<Employee> employees = new ArrayList<>();
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee2");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                boolean contractor = rs.getBoolean("contractor");
                String skillvalue = rs.getString("skills");
                List<String> skills = Arrays.asList(skillvalue.split(","));
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String address = rs.getString("address");
                String country = rs.getString("country");

                employees.add(new Employee(id,name, age,gender,contractor,skills,designation,department,address, country));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return employees;

    }

}
