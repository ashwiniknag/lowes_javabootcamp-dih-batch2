package com.empapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.exception.EmployeeNotFoundException;
import com.empapp.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;
import com.empapp.model.ResponseMessage;
import com.empapp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeServiceImpl empSer;
    // Create Employee

    /*@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ResponseMessage> create(@RequestBody Employee emp) throws URISyntaxException, EmployeeException {
        //Add Employee logic
        Employee empCreated = empSer.create(emp);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empCreated.getEmpID()).toUri();

        ResponseMessage response = new ResponseMessage("Success","Employee created successfully");
        return ResponseEntity.created(location).body(response);
    }*/


    @RequestMapping(value = { "/employee" }, method = RequestMethod.GET)
    public String employee() {
        return "Welcome to RESTful Employee Management Service";
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> create(@RequestBody Employee employee) throws EmployeeException {
// Create employee logic
        empSer.create(employee);
        return ResponseEntity.ok().body("Employee created successfully");
    }
    //get All Employee logic
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Employee> getAll(){return empSer.getAll();}

    //get Employee by id
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public Employee get(@PathVariable int id) throws EmployeeException {
        Employee empbyID = empSer.get(id);
        if (empbyID == null) {
            logger.error("This employee id does not exist: " + id);
            throw new EmployeeNotFoundException("This Employee Id does not exist: " + id);
        }
        return empbyID ;

    }
    //update Employee
    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee employee)
            throws EmployeeException {
        employee.setEmpID(id);

        this.get(id);
        Employee empUpdate = empSer.update(id, employee);
        if (empUpdate == null) {
            logger.error("This employee id does not exist: " + id);
            throw new EmployeeNotFoundException("This Employee Id does not exist: " + id);
        } else
            return ResponseEntity.ok().body("Employee updated successfully");
    }

    // Delete Employee
    @PutMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws EmployeeException{
       empSer.delete(id);

         return ResponseEntity.ok().body("Employee deleted successfully");

    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseMessage> handleErrors(EmployeeException ex) {
        ResponseMessage response = new ResponseMessage("Failure",ex.getMessage());
        return ResponseEntity.internalServerError().body(response);

    }

}
