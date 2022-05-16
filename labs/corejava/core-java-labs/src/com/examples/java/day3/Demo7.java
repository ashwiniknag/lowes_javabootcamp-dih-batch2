package com.Ashwini.class3;

class Test {
    public Test() {
        System.out.println("Default Constructor");
    }

    public Test(int a) {
    System.out.println("Parameterized Constructor");
    }

    public static void Display() {
        System.out.println("Display method");
    }

}

public class Demo7 {
    public static void main(String[] args) {
     Test test =new Test();
     Test test1 =new Test(10);

    }
}
