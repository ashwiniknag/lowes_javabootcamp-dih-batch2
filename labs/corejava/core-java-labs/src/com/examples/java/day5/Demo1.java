package com.examples.java.day5;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = "Hello";
       // char ch[] = {'H', 'e', 'l', 'l', 'o'};
        char[] ch =  {'H', 'e', 'l', 'l', 'o'};

        String s2 = new String(ch);
        //String s3 = new String("world");
        String s3 = "world";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}
