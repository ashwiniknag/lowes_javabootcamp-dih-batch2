package com.empapp.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.empapp.model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;

public class EmployeeDaoImpl implements EmployeeDao{

    MysqlDataSource datasource = null;
    Connection conn =null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;


    public EmployeeDaoImpl(MysqlDataSource datasource) {
        this.datasource = datasource;
    }
    /*public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/jdbctraining";  //URL  for mysql
        String root = "training";
        String password = "training";
        //System.out.println("calling driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(url, root, password);
        // conn.setAutoCommit(false);
        //System.out.println("connected to DB" + conn);
        return conn;
    }*/
    @Override
    public boolean create(Employee emp) {
        boolean status = false;
        try {

            conn = datasource.getConnection();
            stmt = conn.createStatement();

            String query = "INSERT INTO employee (name,age,designation,department,country,salary, dateofjoining, datecreated) VALUES(\""
                    + emp.getEmpName() + "\"," + emp.getAge() + ",\"" + emp.getDesignation() + "\",\""
                    + emp.getDepartment() + "\",\"" + emp.getCountry() + "\",\"" + emp.getSalary() + "\",\"" + emp.getDoj() + "\",\""
                    + LocalDateTime.now() + "\")";
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

            String query = "UPDATE employee SET name = \"" + emp.getEmpName() + "\", age = " + emp.getAge()
                    + " ,designation = \"" + emp.getDesignation() + "\" ,department = \"" + emp.getDepartment()
                    + "\",country=\"" + emp.getCountry()  + "\",salary=\"" + emp.getSalary()+ "\",datemodified=\"" + LocalDateTime.now() + "\" WHERE id = "
                    + emp.getEmpID();
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

            String query = "DELETE FROM employee WHERE id = " + empId;
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
        String query = "SELECT * FROM employee WHERE id = " + empId;
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");
                int salary = rs.getInt("salary");
                LocalDate doj = rs.getDate("dateofjoining").toLocalDate();
                //  LocalDateTime datecreated = rs.getTimestamp("datecreated").toLocalDateTime();
                //  LocalDateTime datemodified = rs.getTimestamp("datemodified").toLocalDateTime();


                emp = new Employee(id, name, age, designation, department, country, salary, doj);

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

        List<Employee> employees = new ArrayList<>();
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");
                int salary = rs.getInt("salary");
                LocalDate doj = rs.getDate("dateofjoining").toLocalDate();



                employees.add(new Employee(id, name, age, designation, department, country, salary, doj));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return employees;

    }

}
