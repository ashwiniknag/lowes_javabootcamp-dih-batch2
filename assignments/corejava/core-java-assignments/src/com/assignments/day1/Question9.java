package com.LowesAssignments.Assignment1;

//program to calculate the sum of the numbers occurring in the multiplication table of 8

public class Question9 {
    public static void main(String[] args) {
        int n =8;
        int i =1;
        int res =0;
        //using if loop
        for(int j=1;j<=10; j++) {
            res = res + (n * j);
        }
        //using while loop
        // while (i<=10){
         //   res = res + (n*i);
           // i++;
       // }
        System.out.println(res);
    }
}
