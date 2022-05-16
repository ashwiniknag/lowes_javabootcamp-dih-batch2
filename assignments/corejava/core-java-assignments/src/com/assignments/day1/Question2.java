package com.LowesAssignments.Assignment1;

//program to sum first n even numbers using a while loop.

public class Question2 {
    public static void main(String[] args) {
        int num = 5;
        int i=2;
        int res = 0;
        while(i%2 == 0 && num >= 1) {
            res= res+i;
            i=i+2;
            num--;
        }
        System.out.println(res);
    }
}
