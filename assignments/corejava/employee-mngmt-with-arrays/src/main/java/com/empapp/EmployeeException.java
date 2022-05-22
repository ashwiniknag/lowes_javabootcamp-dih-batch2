package com.empapp;

public class EmployeeException extends Exception{
    public EmployeeException(){
        System.out.println("Enter integer value for ID");
    }
    public EmployeeException(String message){
        System.out.println(message);
    }

}
