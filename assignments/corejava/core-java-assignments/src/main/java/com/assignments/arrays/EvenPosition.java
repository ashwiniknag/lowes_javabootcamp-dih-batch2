package com.assignments.arrays;
// Java Program to print the elements of an array present on even position

public class EvenPosition {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};

        for(int i=1; i< arr.length; i= i+2){
            System.out.print(arr[i] + " ");
        }
    }
}
