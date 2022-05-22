package com.empapp;

public class EmployeeModel {
        public int empID;
        public String empName;
        public int age;
        public String designation;
         public String location;
        public int salary;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

   /* @Override
    public String toString() {
        return "EmployeeModel{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                '}';
    }
*/
    public EmployeeModel(int empID, String empName, int age, String designation, String location, int salary){
            this.empID = empID;
            this.empName = empName;
            this.age = age;
            this.designation = designation;
            this.location = location;
            this.salary = salary;

        }


}
