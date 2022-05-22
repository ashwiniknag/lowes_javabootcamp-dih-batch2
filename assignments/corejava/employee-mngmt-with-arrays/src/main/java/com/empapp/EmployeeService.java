package com.empapp;

import java.util.Scanner;

public class EmployeeService extends EmployeeException {
    Scanner scanner = new Scanner(System.in);
    int arrSize = 5;
    EmployeeModel empArr[] = new EmployeeModel[arrSize];
    int size = 0;

    public void addEmployee() throws EmployeeException {
        if (size == arrSize) { // if all array rows are populated, throw exception
            throw new EmployeeException("Array is full. Cannot add more employees");
        } else {
            System.out.print("Enter Employee ID - ");
            //int id = scanner.nextInt();
            if (scanner.hasNextInt()) // check if empId is an integer ,add employee else through exception
            {
                int id = scanner.nextInt();
                System.out.print("Enter Employee Name - ");
                String name = scanner.next();
                System.out.print("Enter Employee age - ");
                if (!scanner.hasNextInt()) {
                    throw new EmployeeException("Enter integer value");
                }else {
                    int age = scanner.nextInt();
                    System.out.print("Enter Designation - ");
                    String des = scanner.next();
                    System.out.print("Enter Location - ");
                    String loc = scanner.next();
                    System.out.print("Enter Salary - ");
                    if (!scanner.hasNextInt()) {
                        throw new EmployeeException("Enter integer value");
                    }else {
                        int sal = scanner.nextInt();
                        //for (int i = 0; i < empArr.length; i++) {

                        empArr[size] = new EmployeeModel(id, name, age, des, loc, sal); //addition of employee
                        size++;

                        System.out.println("New Employee added ");
                    }
                }
            } else throw new EmployeeException();
        }
    }

    public void ViewEmp() throws EmployeeException{

        System.out.println("Enter Employee ID");
        if (scanner.hasNextInt()) // check if empId is an integer
        {
            int idNo = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                if (idNo == (empArr[i].getEmpID())) {
                    System.out.println(empArr[i].getEmpID() + " " + empArr[i].getEmpName() + " " + empArr[i].getAge() + " " + empArr[i].getDesignation() + " " + empArr[i].getLocation() + " " + empArr[i].getSalary());
                    break;
                }

            }
        } else throw new EmployeeException( "Enter valid Id");

    }

    public void viewAllEmp() {
        for (int j = 0; j < size; j++) {

            System.out.println(empArr[j].getEmpID() + " " + empArr[j].getEmpName() + " " + empArr[j].getAge() + " " + empArr[j].getDesignation() + " " + empArr[j].getLocation() + " " + empArr[j].getSalary());

        }
    }

    public void empUpdate() throws EmployeeException {
        {
            System.out.println("Enter Employee ID");
            if (scanner.hasNextInt()) // check if empId is an integer ,Update employee else through exception
            {
                int idNo = scanner.nextInt();
                System.out.print("Enter Employee Name - ");
                String name = scanner.next();
                System.out.print("Enter Employee age - ");
                int age = scanner.nextInt();
                System.out.print("Enter Designation - ");
                String des = scanner.next();
                System.out.print("Enter Location - ");
                String loc = scanner.next();
                System.out.print("Enter Salary - ");
                int sal = scanner.nextInt();


                for (int i = 0; i < size; i++) {
                    if (idNo == (empArr[i].getEmpID())) {
                        empArr[i].setEmpName(name);
                        empArr[i].setAge(age);
                        empArr[i].setDesignation(des);
                        empArr[i].setLocation(loc);
                        empArr[i].setSalary(sal);
                        break;
                    }

                }
                System.out.println("employee updated");
            } else throw new EmployeeException();

        }
    }
        public void empDelete() throws EmployeeException
    {
            System.out.println("Enter Employee ID");
            if (scanner.hasNextInt()) // check if empId is an integer ,Update employee else through exception
            {
                int idNo = scanner.nextInt();

                for (int i = 0; i < size; i++) {
                    if (idNo == (empArr[i].getEmpID())) {
                        if (i == (size - 1)) {
                            //if Emd Id is in last index.
                        }
                        else { // push all rows upwards for deletion
                            for (int j = i; j < size - 1; j++) {
                                empArr[j].empID = empArr[j + 1].empID;
                                empArr[j].empName = empArr[j + 1].empName;
                                empArr[j].age = empArr[j + 1].age;
                                empArr[j].designation = empArr[j + 1].designation;
                                empArr[j].location = empArr[j + 1].location;
                                empArr[j].salary = empArr[j + 1].salary;
                            }

                        }
                        size--;
                    }
                }
                System.out.println("Employee deleted");
            } else throw new EmployeeException();

        }
    }
