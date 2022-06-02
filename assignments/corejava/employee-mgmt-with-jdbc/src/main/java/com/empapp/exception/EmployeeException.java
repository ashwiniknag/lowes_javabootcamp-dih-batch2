package com.empapp.exception;

public class EmployeeException extends Exception{
    public EmployeeException()
    {
        System.out.println("Enter integer value for ID");
    }

    public EmployeeException(String message)
    {
        super(message);
    }
}
