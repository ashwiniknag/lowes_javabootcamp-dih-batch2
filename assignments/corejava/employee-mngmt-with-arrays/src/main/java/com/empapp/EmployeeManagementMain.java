package com.empapp;
import java.util.Scanner;

public class EmployeeManagementMain extends EmployeeException{

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


    public static void main(String[] args) throws EmployeeException {
        Scanner scn = new Scanner(System.in);
        EmployeeService EmpSer = new EmployeeService();
        do {
            showMenu();
            System.out.println("Enter your Option");
            if (!scn.hasNextInt()) {
                throw new EmployeeException("Enter integer value");
            }else {
                int option = scn.nextInt();
                switch (option) {
                    case 1:
                        EmpSer.addEmployee();

                        break;
                    case 2:
                        EmpSer.ViewEmp();
                        break;
                    case 3:
                        EmpSer.empUpdate();
                        break;
                    case 4:
                        EmpSer.empDelete();
                        break;
                    case 5:
                        EmpSer.viewAllEmp();
                        break;
                    case 6:
                        System.out.println("Thank you for using the application");
                        System.exit(0);
                        break;
                    default:
                        throw new EmployeeException("Enter valid option");
                }
            }
        } while (workinprogress);
    }
}

