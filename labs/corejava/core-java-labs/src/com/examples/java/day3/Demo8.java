package com.Ashwini.class3;

class Student{
    public Student(){
        System.out.println("1st Constructor");
    }

    public Student(int a) {
        System.out.println("2nd Constructor");
    }

    public Student(String a) {
        System.out.println("3rd Constructor");
    }

    public Student(int a, String b) {
        System.out.println("4th Constructor");
    }

    public Student(String a, int b){
        System.out.println("5th Constructor");
    }
}

public class Demo8 {
    public static void main(String[] args) {
        Student student1 =new Student();
        Student student2 =new Student(10);
        Student student3 =new Student("hi");
        Student student4 =new Student(20, "hello");
        Student student5 =new Student("bye", 40);
    }
}
