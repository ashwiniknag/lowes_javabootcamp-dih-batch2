package com.empapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.empapp.model.ResponseMessage;

public class EmployeeExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleGenericErrors(Exception ex) {
        ResponseMessage response = new ResponseMessage("Failure",ex.getMessage());
        return ResponseEntity.internalServerError().body(response);

    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseMessage> handleErrors(EmployeeException ex) {
        ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    // override method of ResponseEntityExceptionHandler class
    public final ResponseEntity<Object> handleEmpNotFoundExceptions(EmployeeNotFoundException ex) {
        // creating exception response structure
        ResponseMessage responseMessage = new ResponseMessage("Not Found", ex.getMessage());
        // returning exception structure and specific status
        return new ResponseEntity(responseMessage, HttpStatus.NOT_FOUND);

    }
}
