package com.Ashwini.class4;

import java.sql.SQLOutput;

class Student{
    public int rollNo;
    public String name;
    static public String school = "vidya mindir";
}
public class Demo4 {
    public static void main(String[] args) {
        Student S1 = new Student();
        Student S2 = new Student();

        S1.rollNo = 111;
        S1.name = "aaa";
        S2.rollNo = 222;
        S2.name = "bbb";

        System.out.println("Student id- " + S1.rollNo + " Student name- "+ S1.name + "Student School- " + Student.school);
        System.out.println("Student id- " + S2.rollNo + " Student name- "+ S2.name + "Student School- " + Student.school);
    }
}