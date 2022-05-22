package com.assignments.Calculator;

import java.util.Scanner;

class Calculator{
    float c;
    public void addition( float a,float b){
        c = a+b;
        System.out.println("sum of "+ a + " and " + b +" is - " + c );
    }

    public void subtraction(float a,float b) {
        if (a >= b) {
            c = a - b;
            System.out.println("Difference of " + a + " and " + b + " is - " + c);
        } else System.out.println("Enter valid numbers");

    }

    public void multiplication(float a,float b){
        c=a*b;
        System.out.println("Multiplication of "+ a + " and " + b +" is - " + c );
    }

    public void division(float a,float b){
        if(a>0 && b>0) {
            c = a / b;
            System.out.println("Division of " + a + " and " + b + " is - " + c);
        }else  System.out.println("Enter valid numbers");
    }

}
public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to calculator app.");
        System.out.println("Enter First number");
        float a = scanner.nextFloat();
        System.out.println("Enter Second number");
        float b = scanner.nextFloat();

        System.out.println("Press 1 for Addition" + "\n" + "Press 2 for for subtraction" +
                "\n" + "Press 3 for for multiplication" + "\n" + "Press 4 for for division");
        int c = scanner.nextInt();

        switch (c) {
            case 1:
                calculator.addition(a, b);
                break;
            case 2:
                calculator.subtraction(a, b);
                break;
            case 3:
                calculator.multiplication(a, b);
                break;
            case 4:
                calculator.division(a, b);
                break;
            default:
                System.out.println("Enter valid number");
                break;

        }


    }
}