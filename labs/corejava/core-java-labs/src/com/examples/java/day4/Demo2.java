package com.Ashwini.class4;

class Parent {
    public Parent() {
        System.out.println("parent constructor");
    }

    public void test1() {
        System.out.println("Parent - method");
    }
}

class Child extends Parent{
        public Child(){
            System.out.println("Child constructor");
        }

        public void test2(){
            System.out.println("Child method");
        }
}
public class Demo2 {
    public static void main(String[] args) {
        Parent p1 =new Parent();
        Child c1 = new Child();
        c1.test2();
        c1.test1();

        p1. test1();

    }
}
