package com.examples.empapp.controller;

import com.examples.empapp.exception.LoginException;
import com.examples.empapp.model.Employee;
import com.examples.empapp.model.User;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@SessionAttributes("userName")
public class SignupController {

    @Autowired
    UserService UserSer;
    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

    @ModelAttribute("user")
    public User createUserModel() {
        return new User();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(Model model) {
        logger.info("================");
        return new ModelAndView("signup", "command", new User());
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    @ExceptionHandler(LoginException.class)
    public ModelAndView adduser(@ModelAttribute User user, Model model, HttpServletRequest request, HttpServletResponse response) {

       if(! UserSer.create(user) ){
           logger.info("User Registration successful. Please login now");
           return new ModelAndView("userRegSuccess");
       }else
           return new ModelAndView("redirect:/signup");

    }
}
