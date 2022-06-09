package com.examples.empapp.service;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.UserDao;
import com.examples.empapp.dao.UserDaoImpl;
import com.examples.empapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao =userDao;
    }

    public boolean create(User user) {
        logger.info("Service UserName"+ user );
        return userDao.create(user);
    }


    public User get(String UserName) {
        logger.info("Service UserName"+UserName );
        return userDao.get(UserName);


    }
}
