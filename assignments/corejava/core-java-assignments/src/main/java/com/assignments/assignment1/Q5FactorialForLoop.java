package com.assignments.assignment1;

public class Q5FactorialForLoop {
    public static void main(String[] args) {
        int num = 8;
        int res = 1;
        for (int i=1; i<=num; i++) {
            res=res*i;

        }
        System.out.println(res);
    }
}
