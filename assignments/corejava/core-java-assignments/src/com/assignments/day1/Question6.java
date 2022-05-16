package com.LowesAssignments.Assignment1;

//program to find the factorial of a given number using while loops

public class Question6 {
    public static void main(String[] args) {
        int num= 8;
        int i=1;
        int res =1;
        while(i<=num) {
            res =res * i;
            i++;
        }
        System.out.println(res);
    }
}
