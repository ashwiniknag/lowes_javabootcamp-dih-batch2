package com.Ashwini.class4;

class Employee {
    public int empID;
    public String firstName;
    public String lastName;
    public String email;
    private int bankAcc;

    public void getFullName(){
        System.out.println(firstName + " " + lastName);
    }
}

class FUllTimeEmp extends Employee {
    public int annualSal;
}

class PartTimeEmp extends Employee {
    public int hourSal;
}

public class Demo1 {
    public static void main(String[] args) {
         FUllTimeEmp fte = new FUllTimeEmp();
         fte.firstName = "James";
         fte.lastName = "Bond";

         PartTimeEmp pte = new PartTimeEmp();
         pte.firstName = "Jason";
         pte.lastName = "Bourne";

         fte.getFullName();
         pte.getFullName();

    }


}
