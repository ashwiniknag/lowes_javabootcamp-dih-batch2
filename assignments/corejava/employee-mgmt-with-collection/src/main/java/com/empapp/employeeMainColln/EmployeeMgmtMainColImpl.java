package com.empapp.employeeMainColln;

import com.empapp.exception.EmployeeException;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeServiceColImpl;

public class EmployeeMgmtMainColImpl extends EmployeeException {

    static int option;
    static Boolean workinprogress = true;

    public static void showMenu() {
        System.out.println("************** Welcome to Employee Management Application *************"
                + "\n1. Add Employee "
                + "\n2. View Employee"
                + "\n3. Update Employee"
                + "\n4. Delete Employee"
                + "\n5. View All Employee"
                + "\n6. Exit");

    }

    static void printHeader() {
        System.out.println("EmpID \t" + "Name\t" + "Age\t" + "Designation\t" + "Location\t"  + "Salary");
    }


    public static void main(String[] args) throws EmployeeException {

        EmployeeServiceColImpl empSer = new EmployeeServiceColImpl();
        Scanner scn = new Scanner(System.in);

        do {
            showMenu();
          try {
                System.out.println("Enter your Option");
                option = scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter Integer Value for option");
                  }

            switch (option) {
                case 1:
                    Employee emp1 = new Employee();
                    empSer.create(getEmp(emp1));
                    System.out.println("Employee added");
                    break;
                case 2:
                            int empID = getEmpId();
                        try {
                        Employee emp = empSer.get(empID);
                        printHeader();
                        System.out.println(emp.getEmpID() + "\t" +"\t" + emp.getEmpName() + "\t" + emp.getAge() + "\t" +
                                emp.getDesignation() + "\t" +"\t" + emp.getLocation() + "\t" +
                                emp.getSalary());

                         } catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                            continue;
                         }
                        break;

                case 3:
                    System.out.println("Enter employee id to be updated");
                    empID = scn.nextInt();
                    Employee emp2;
                    try {
                        emp2 = empSer.findByEmpId(empID);
                    } catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    empSer.update(getEmp(emp2));

                    System.out.println("Employee updated");

                    break;
                case 4:
                                int empId = getEmpId();
                                try {
                                    Boolean del = empSer.delete(empId);
                                    if (del) {
                                        System.out.println("Employee deleted");
                                    }
                                } catch (EmployeeException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                break;
                case 5:
                                List<Employee> emp = empSer.getAll();
                                printHeader();
                                for (Employee employee : emp) {
                                    System.out.println(employee.getEmpID() + "\t" + "\t" + employee.getEmpName() + "\t" + employee.getAge() + "\t" +
                                            employee.getDesignation() + "\t" + employee.getLocation() + "\t" +
                                            employee.getSalary());
                                }
                                break;
                case 6:
                                System.out.println("Thank you for using the application");
                                System.exit(0);
                                break;
                            default:
                                throw new EmployeeException("Enter valid option");
                        }
                    } while (workinprogress) ;

        }

    static Employee getEmp(Employee emp) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Employee Name - ");
        emp.setEmpName(scn.next());
        System.out.print("Enter Employee age - ");
        emp.setAge(scn.nextInt());
        System.out.print("Enter Designation - ");
        emp.setDesignation(scn.next());
        System.out.print("Enter Location - ");
        emp.setLocation(scn.next());
        System.out.print("Enter Salary - ");
        emp.setSalary(scn.nextInt());
        return emp;
    }

    static int getEmpId() {
        do {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Enter employee ID ");

                return (sc.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Enter valid Employee ID");
                sc.nextLine();
            }

        } while (true);
    }

}