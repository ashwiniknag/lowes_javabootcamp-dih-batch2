package com.assignments.arrays;
// Java Program to print the number of elements present in an array

public class NoOfElements {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int count = 0;

        System.out.println("Number of Elements in array using length method- " + arr.length);


        for (int i=0; i<6; i++){
            count++;
        }
        System.out.println("Number of Elements in array using counter - " +count);

    }
}
