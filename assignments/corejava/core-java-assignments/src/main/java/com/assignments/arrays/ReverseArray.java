package com.assignments.arrays;
//Java Program to print the elements of an array in reverse order

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};

        System.out.println("Original Order");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //reverse order

        System.out.println("Array in reverse order - ");
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");

        }
    }
}
