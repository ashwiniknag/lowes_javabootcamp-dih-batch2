package com.empapp.employeeMgmtMainJDBC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeServiceJDBCImpl;
import com.empapp.exception.EmployeeException;


public class EmployeeMainJDBC extends EmployeeException{
    static int option;
    static Boolean workinprogress = true;

    public static void showMenu() {
        System.out.println("************** Welcome to Employee Management Application *************"
                + "\n1. Add Employee "
                + "\n2. View Employee"
                + "\n3. Update Employee"
                + "\n4. Delete Employee"
                + "\n5. View All Employee"
                + "\n6. Print Statistics"
                + "\n7. Import"
                + "\n8. Export"
                + "\n9. Exit");

    }
    public static EmployeeServiceJDBCImpl empSer = new EmployeeServiceJDBCImpl();
    static void printHeader() {
        System.out.println("EmpID \t" + "Name\t" + "Age\t" + "Designation\t" + "Department\t" + "Country\t" + "Salary\t" + "Dateofjoining");
    }


    public static void main(String[] args) throws EmployeeException {

        Employee emp = new Employee();
        Scanner scn = new Scanner(System.in);
        ExecutorService exec = Executors.newCachedThreadPool();


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
                    //Employee emp1 = new Employee();
                    empSer.create(getEmp(emp));
                    System.out.println("Employee added");
                    break;
                case 2:
                    int empID = getEmpId();
                    try {
                    emp = empSer.get(empID);
                    printHeader();
                    System.out.println(emp.getEmpID() + "\t" + "\t" + emp.getEmpName() + "\t" + emp.getAge() + "\t" +
                            emp.getDesignation() + "\t" + emp.getDepartment() + "\t" + emp.getCountry() + "\t" +
                            emp.getSalary() + "\t" + emp.getDoj());

                 }    catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("Enter employee id to be updated");
                    empID = scn.nextInt();
                    emp =empSer.get(empID);
                    empSer.update(getEmp(emp));
                    System.out.println("Employee updated");
                    break;

                case 4:
                    int empId = getEmpId();
                    Boolean del = empSer.delete(empId);
                    System.out.println("Employee deleted");

                    break;

                case 5:
                    List<Employee> emp1 = empSer.getAll();
                    printHeader();
                    for (Employee employee : emp1) {
                        System.out.println(employee.getEmpID() + "\t" + "\t" + employee.getEmpName() + "\t" + employee.getAge() + "\t" +
                                employee.getDesignation() + "\t" + employee.getDepartment() + "\t" + employee.getCountry() + "\t" +
                                employee.getSalary()+ "\t" +  employee.getDoj());
                    }
                    break;

                case 6: printStatistics();
                    break;

                case 7:  Future<Boolean> impFuture = exec.submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        System.out.println("Import Process with Thread name: " + Thread.currentThread().getName());
                        Thread.sleep(2000);
                        empSer.bulkImport();
                        return true;
                    }
                });
                    break;

                case 8: Future<Boolean> exportFutr = exec.submit(new Callable<Boolean>()
                {
                    @Override
                    public Boolean call() throws Exception {
                        System.out.println("\n"+Thread.currentThread() + " Will start export process soon");
                        Thread.sleep(2000);
                        empSer.bulkExport();
                        return true;
                    }
                });
                    break;

                case 9:
                    exec.shutdown();
                    System.out.println("Thank you for using the application");
                    System.exit(0);
                    break;

                default:
                    throw new EmployeeException("Enter valid option");
            }
        } while (workinprogress) ;

    }

    static Employee getEmp(Employee emp) {
        EmployeeServiceJDBCImpl empSer1 = new EmployeeServiceJDBCImpl();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Employee Name - ");
        emp.setEmpName(scn.next());
        try {
            boolean var = true;
            do {
                System.out.print("Enter Employee age - ");
                String errMsg = "Enter age between 18 and 60 yrs";
                emp.setAge(scn.nextInt());
                var = empSer1.validate(emp, errMsg, emp1 -> emp1.getAge() >= 18 && emp1.getAge() <= 60, msg -> {
                    System.out.println(msg);
                    return false;
                });
            } while (!var);
        } catch (NumberFormatException e) {
            System.out.println();
        }


        System.out.print("Enter Designation - ");
        emp.setDesignation(scn.next());
        System.out.print("Enter Department - ");
        emp.setDepartment(scn.next());
        System.out.print("Enter Country - ");
        emp.setCountry(scn.next());
        System.out.print("Enter Salary - ");
        emp.setSalary(scn.nextInt());
        System.out.print("Enter Date of joining in dd/mm/yyyy format - ");
        String doj = scn.next();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(doj, dateFormat);
        emp.setDoj(date);
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

    private static void printStatistics(){

        System.out.println("No of employees older than thirty years: " + empSer.getEmployeeCountAgeGreaterThan(e->e.getAge()>30));
        System.out.println("List employee IDs older than thirty years: " + empSer.getEmployeeIdsAgeGreaterThan(30));
        System.out.println("Employee count by Department: " + empSer.getEmployeeCountByDepartment());
        System.out.println("Employee count by Department ordered: " + empSer.getEmployeeCountByDepartmentOrdered());
        System.out.println("Average Employee Age by Department:" + empSer.getAvgEmployeeAgeByDept());
        System.out.println("List Departments have more than 3 employees: " + empSer.getDepartmentsHaveEmployeesMoreThan(3));
        System.out.println("List Employees starts with 'S': " + empSer.getEmployeeNamesStartsWith("S"));
        System.out.println("Average Employee experience by Department: " + empSer.getAvgEmployeeServiceByDept());

    }

}



