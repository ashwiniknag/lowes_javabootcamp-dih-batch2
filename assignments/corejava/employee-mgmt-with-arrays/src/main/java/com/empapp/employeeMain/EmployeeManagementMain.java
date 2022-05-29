package com.empapp.employeeMain;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.empapp.exception.EmployeeException;
import com.empapp.service.EmployeeService;
import com.empapp.model.Employee;
public class EmployeeManagementMain extends EmployeeException {
  static int id;
  static String name;
    static int age;
    static String des;
    static String loc;
    static int sal;
    static int option;
    static Boolean workinprogress = true;

    /*static int chkEmpId() {
            int id;
           do{
            try {

                System.out.print("Enter Employee ID - ");
                Scanner scn = new Scanner(System.in);
                id = scn.nextInt();
                return id;
            } catch (InputMismatchException ex) {
                System.out.println("Enter Valid Input Id");
            }
        } while(true);

    }*/




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

            EmployeeService empSer = new EmployeeService();
            Scanner scn = new Scanner(System.in);

        do {
            showMenu();

                System.out.println("Enter your Option");
                 option = scn.nextInt();

                switch (option) {
                    case 1:

                            try {
                                System.out.print("Enter Employee ID - ");
                                id = scn.nextInt();
                                System.out.print("Enter Employee Name - ");
                                name = scn.next();
                                System.out.print("Enter Employee age - ");
                                age = scn.nextInt();
                                System.out.print("Enter Designation - ");
                                des = scn.next();
                                System.out.print("Enter Location - ");
                                loc = scn.next();
                                System.out.print("Enter Salary - ");
                                sal = scn.nextInt();
                                empSer.addEmployee(id, name, age, des, loc, sal);
                            } catch(InputMismatchException e){
                                    throw new EmployeeException("Enter Valid Input");
                                }
                            break;
                    case 2: ;
                            System.out.print("Enter Employee ID - ");
                            id = scn.nextInt();
                            empSer.ViewEmp(id);
                            break;

                    case 3:

                            try{
                                System.out.print("Enter Employee ID - ");
                                id = scn.nextInt();
                            System.out.print("Enter Employee Name - ");
                            name = scn.next();
                            System.out.print("Enter Employee age - ");
                            age = scn.nextInt();
                            System.out.print("Enter Designation - ");
                            des = scn.next();
                            System.out.print("Enter Location - ");
                            loc = scn.next();
                            System.out.print("Enter Salary - ");
                            sal = scn.nextInt();
                            empSer.empUpdate(id, name, age, des, loc, sal);
                            } catch(InputMismatchException e){
                                throw new EmployeeException("Enter Valid Input");
                            }
                            break;
                    case 4:
                            System.out.print("Enter Employee ID - ");
                            id = scn.nextInt();
                            empSer.empDelete(id);
                            break;
                    case 5:
                             empSer.viewAllEmp();
                            break;
                    case 6:
                             System.out.println("Thank you for using the application");
                             System.exit(0);
                             break;
                    default:
                           throw new EmployeeException("Enter valid option");
                }
        } while (workinprogress);

}

}

