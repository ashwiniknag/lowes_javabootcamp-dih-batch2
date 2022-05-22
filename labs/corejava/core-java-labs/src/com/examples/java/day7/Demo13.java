package com.examples.java.day7;
import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First name");
        String firstName = scanner.next();
        System.out.println("Enter Last name");
        String lastname = scanner.next();
        System.out.println( "Full name is  - " + firstName + " " + lastname);

    }
}
