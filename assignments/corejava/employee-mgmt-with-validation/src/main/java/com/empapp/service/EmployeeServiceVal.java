package com.empapp.service;
import com.empapp.model.Employee;
import com.empapp.exception.EmployeeException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeServiceVal implements EmployeeService {
    int empIdCount = 1;
    Map<Integer, Employee> empMap = new HashMap<>();


    @Override
    public boolean create(Employee emp) {
        emp.setEmpID(empIdCount++);
        empMap.put(emp.getEmpID(), emp);
        return true;
    }

    @Override
    public boolean update(Employee emp) {
        empMap.replace((emp.getEmpID()), emp);
        return true;
    }

    @Override
    public boolean delete(int empId) throws EmployeeException {
        Employee empDel = empMap.remove(empId);
        if (empDel != null) {
            return true;
        } else {
            throw new EmployeeException("Employee not in the list ");
        }
    }


    @Override
    public Employee get(int empID) throws EmployeeException {
        Employee emp = findByEmpId(empID);
        if (emp == null)
            throw new EmployeeException("Employee does not exist");
        return emp;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> empList = new ArrayList(empMap.values());
        return empList;
    }

    @Override
    public void bulkImport() {
        System.out.println("Import Started " + Thread.currentThread().getName());
        BufferedReader inBuffer = null;
        String line = null;
        try {
            inBuffer = new BufferedReader(new FileReader("c:/Users/Ashwini/Training/lowes_javabootcamp-dih-batch2/assignments/corejava/employee-mgmt-with-impexp/src/main/java/com/empapp/input.txt"));
            while ((line = inBuffer.readLine()) != null) {
                String[] tokens = line.split(",");
                Employee emp = new Employee();
                emp.setEmpID(Integer.parseInt(tokens[0]));
                emp.setEmpName(tokens[1]);
                emp.setAge(Integer.parseInt(tokens[2]));
                emp.setDesignation(tokens[3]);
                emp.setLocation(tokens[4]);
                emp.setSalary(Integer.parseInt(tokens[5]));

                create(emp);
            }
            System.out.println("Bulk Import Success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public synchronized void bulkExport() {
        System.out.println("\n" + Thread.currentThread().getName() + " - Export started");
        int count = 0;
        try {
            FileWriter fExp = new FileWriter("c:/Users/Ashwini/Training/lowes_javabootcamp-dih-batch2/assignments/corejava/employee-mgmt-with-impexp/src/main/java/com/empapp/Output.txt");

            ArrayList<Employee> empArr = new ArrayList<Employee>(empMap.values());

            for (Employee emp : empArr) {
                String str = emp.getEmpID() + "," + emp.getEmpName() + "," + emp.getAge() + "," + emp.getDesignation() + "," + emp.getLocation() + "," + emp.getSalary();
                fExp.write(str + "\n");
                count++;
            }
            fExp.flush();
            fExp.close();
            System.out.println(Thread.currentThread().getName() + " - " + count + " Employee records exported");

        } catch (IOException e) {
            System.out.println("Error in importing employee data from the file" + e.getMessage());
        }
    }

    @Override
    public boolean validate(Employee emp, String msg, Predicate<Employee> condition,
                            Function<String, Boolean> operation){
        if(!condition.test(emp)){
            return operation.apply(msg);
        }
        return true;

    }


    public Employee findByEmpId(int empId) throws EmployeeException {
        Employee emp = empMap.get(empId);
        if (emp == null) {
            throw new EmployeeException("This employee does not exist");
        } else {
            return emp;
        }
    }

}
