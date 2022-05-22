package com.examples.java.day5;

public class Demo7 {
    public static void main(String[] args) {
        String msg = "welcome to java full stack training";
        System.out.println(msg.substring(0,7));

        System.out.println("original message - " + msg);
        System.out.println("substring from index 7 - "+ msg.substring(7));
        System.out.println("substring from 0 to 12 - " + msg.substring(0,15) );

        String str = new String("Welcome home");
        System.out.println(str);
        System.out.println(str.substring(8));

    }
}
