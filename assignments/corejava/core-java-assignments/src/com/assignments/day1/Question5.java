package com.LowesAssignments.Assignment1;

//program to find the factorial of a given number using for loops

public class Question5 {
    public static void main(String[] args) {
        int num = 8;
        int res = 1;
        for (int i=1; i<=num; i++) {
            res=res*i;

        }
        System.out.println(res);
    }
}
