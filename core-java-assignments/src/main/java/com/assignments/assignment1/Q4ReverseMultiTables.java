package com.assignments.assignment1;
//program to print a multiplication table of 10 in reverse order
public class Q4ReverseMultiTables {
    public static void main(String[] args) {
        int num = 10;
        for(int i=10; i>=1;--i) {
            System.out.println(num + "x" + i +"=" + num*i);
        }
    }
}
