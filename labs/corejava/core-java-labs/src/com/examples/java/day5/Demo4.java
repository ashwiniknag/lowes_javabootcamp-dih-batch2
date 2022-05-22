package com.examples.java.day5;

public class Demo4 {
    public static void main(String[] args) {
        String s1 = "Mark";
        String s2 = "Mark";
        String s3 = new String("Mark");
        String s4 = new String("Mark");

        System.out.println(s1==s2);//true because both refers to the same instance
        System.out.println(s1==s3);//false because s3 refers to instance created in normal heap
        System.out.println(s3==s4);//false
    }
}
