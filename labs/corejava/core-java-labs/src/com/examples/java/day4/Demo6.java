package com.Ashwini.class4;

class Calculator {
    //nonstatic method
    public void addNumber(int a, int b){
        System.out.println(a+b);
    }
    //static method
    public static void subNumber(int a, int b) {
        System.out.println(a-b);

    }
}
public class Demo6 {
    public static void main(String[] args) {
        Calculator C1 = new Calculator();
        C1.addNumber(100, 100);
        Calculator.subNumber(100, 60);

    }
}
