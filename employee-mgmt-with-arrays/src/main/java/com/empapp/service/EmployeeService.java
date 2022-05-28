package com.empapp.service;
import com.empapp.exception.EmployeeException;
import com.empapp.model.Employee;

import java.util.InputMismatchException;

public class EmployeeService extends EmployeeException {

    int arrSize = 5;
    Employee empArr[] = new Employee[arrSize];
    int size = 0;
    public void addEmployee(int id, String name, int age, String des, String loc, int sal) throws EmployeeException {
        if (size == arrSize) { // if all array rows are populated, throw exception
            throw new EmployeeException("Array is full. Cannot add more employees");
        } else {
            empArr[size] = new Employee(id, name, age, des, loc, sal); //addition of employee
            size++;
            System.out.println("New Employee added ");
        }
    }

    public void ViewEmp(int id)
    {
            for (int i = 0; i < size; i++) {
            if (id == (empArr[i].getEmpID())) {
                System.out.println(empArr[i].getEmpID() + " " + empArr[i].getEmpName() + " " + empArr[i].getAge() + " " + empArr[i].getDesignation() + " " + empArr[i].getLocation() + " " + empArr[i].getSalary());
                break;
            }

        }


    }


    public void viewAllEmp() {
        for (int j = 0; j < size; j++) {

            System.out.println(empArr[j].getEmpID() + " " + empArr[j].getEmpName() + " " + empArr[j].getAge() + " " + empArr[j].getDesignation() + " " + empArr[j].getLocation() + " " + empArr[j].getSalary());

        }
    }

    public void empUpdate(int idNo, String name, int age, String des, String loc, int sal)
    {

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
            }

    public void empDelete (int idNo)
    {
        for (int i = 0; i < size; i++) {
            if (idNo == (empArr[i].getEmpID())) {
                if (i == (size - 1)) {
                    //if Emd Id is in last index.
                }
                else { // push all rows upwards for deletion
                    for (int j = i; j < size - 1; j++)
                    {

                          empArr[j] = empArr[j+1];
                    }

                }
                size--;
            }
        }
        System.out.println("Employee deleted");

    }


}
