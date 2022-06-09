package com.examples.empapp.dao;

import com.examples.empapp.model.Employee;
import com.examples.empapp.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
    MysqlDataSource datasource = null;
    Connection conn =null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;


    public UserDaoImpl(MysqlDataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public boolean create(User user) {
       boolean status = false;
        try {

            conn = datasource.getConnection();
            stmt = conn.createStatement();
            logger.info("username in Dao -add" );
            String query = "INSERT INTO user (name,emailID,password) VALUES(\""
                    + user.getUserName() + "\",'" + user.getEmailID() + "',\"" + user.getPassword() + "\")";
            logger.info("username in Dao" + query);
            status = stmt.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    @Override
    public User get(String UserName) {

        logger.info("username in Dao - get" + UserName);
        User user = null;
        String query = "SELECT * FROM user WHERE name = '"+UserName + "'";
        logger.info("username in Dao" + query);
        try {
            conn = datasource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String userName = rs.getString("name");

                String password = rs.getString("password");

                user = new User(userName,password);

            }

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("This user does not exist!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;

    }
}
