package com.empapp.model;

public class Employee {
    private int empID;
    private String empName;
    private int age;
    private String designation;

    private String department;
    private String country;
    private int salary;

    public Employee() {

    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String location) {
        this.country = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Employee(int empID, String empName, int age, String designation, String department, String country, int salary){
        this.empID = empID;
        this.empName = empName;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.country = country;
        this.salary = salary;

    }

}
