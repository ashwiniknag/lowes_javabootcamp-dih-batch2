package com.empapp.service;
import com.empapp.model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.empapp.dao.EmployeeDao;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.exception.*;
public class EmployeeServiceJDBCImpl implements EmployeeService{

    EmployeeDao empDao;
    Map<Integer, Employee> empMap = new HashMap<>();
 Comparator<Employee> EMPLOYEE_NAME_ASC_SORT = new Comparator<Employee>() {

        public int compare(Employee e1, Employee e2) {
            return e1.getEmpName().compareTo(e2.getEmpName());
        }
    };

    public EmployeeServiceJDBCImpl() {
        empDao = new EmployeeDaoImpl();
    }

    @Override
    public boolean create(Employee emp) {
        return empDao.create(emp);
    }

    @Override
    public boolean update(Employee emp) {

        return empDao.update(emp);
    }

    @Override
    public boolean delete(int empId) {
        return empDao.delete(empId);

    }

    @Override
    public Employee get(int empId) throws EmployeeException {
        return empDao.get(empId);
    }

    @Override
    public List<Employee> getAll() {

        return empDao.getAll();
    }

    public void bulkImport() {
        System.out.println("Import Started " + Thread.currentThread().getName());
        BufferedReader in = null;
        String line = null;
        try {

            in = new BufferedReader(new FileReader(".\\input.txt"));
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(",");
                Employee emp = new Employee();

               // emp.setEmpID(Integer.parseInt(tokens[0]));
                emp.setEmpName(tokens[0]);
                emp.setAge(Integer.parseInt(tokens[1]));
                emp.setDesignation(tokens[2]);
                emp.setDepartment(tokens[3]);
                emp.setCountry(tokens[4]);
                emp.setSalary(Integer.parseInt(tokens[5]));
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(tokens[6], dateFormat);
                emp.setDoj(date);


                empDao.create(emp);
            }
            System.out.println("Bulk Import Success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void bulkExport() {

        System.out.format("%n%s - Export started %n", Thread.currentThread().getName());
        PrintWriter out = null;

        List<Employee> employees = new ArrayList<>();
        employees = empDao.getAll();
        try {

            out = new PrintWriter(".\\output.txt");
            for (Employee emp : employees) {
                out.write(emp.getEmpID() + "," + emp.getEmpName() + "," + emp.getAge() + "," + emp.getDesignation() + ","
                        + emp.getDepartment() + "," + emp.getCountry() + "," + emp.getSalary() + "," + emp.getDoj() +"\n");
            }
            out.flush();
            System.out.println("\n" + "File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file..");
        } finally {
            if (out != null) {
                out.close();
            }
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

    @Override
    public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition) {
        long count = this.getAll().stream().filter(condition).count();
        return count;
    }

    @Override
    public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
        List<Integer> empid = this.getAll()
                .stream()
                .filter(emp->emp.getAge()>age)
                .map(Employee::getEmpID)
                .collect(Collectors.toList());
        return empid;
    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartment() {
        return this.getAll()
                .stream()
                .map(Employee::getDepartment)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartmentOrdered() {
        return this.getAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment,LinkedHashMap::new, Collectors.counting()));
    }

    @Override
    public Map<String, Double> getAvgEmployeeAgeByDept() {
        return this.getAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.averagingInt(Employee::getAge)));
    }

    @Override
    public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria) {
        return this.getAll().
                stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() >criteria).map(Map.Entry::getKey).collect(Collectors.toList());

    }

    @Override
    public List<String> getEmployeeNamesStartsWith(String prefix) {
        return this.getAll()
                .stream()
                .filter(emp ->emp.getEmpName().startsWith(prefix))
                .map(Employee::getEmpName)
                .collect(Collectors.toList());
    }


    public Employee findByEmpId(int empId) throws EmployeeException {
        Employee emp = empMap.get(empId);
        if (emp == null) {
            throw new EmployeeException("This employee does not exist");
        } else {
            return emp;
        }
    }
  @Override
  public Map<String, Double> getAvgEmployeeServiceByDept() {
      return this.getAll()
              .stream()
              .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(employees -> {
                  Period period = Period.between(employees.getDoj(), LocalDate.now());
                  return period.getYears();
              })));
  }
}
