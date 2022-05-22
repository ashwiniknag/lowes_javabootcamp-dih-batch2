package com.assignments.arrays;
//Java Program to left rotate the elements of an array

public class LeftRotate {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int noOfTimes = 3;
        int n;
        int j;

        System.out.println("Original array - " );
        for(int i =0;i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        //Rotate the given array by noOfTimes times towards left
        for (int i = 0; i< noOfTimes; i++) {
            n = arr[0];

            for (j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];

            }
            arr[j] = n;
        }
        System.out.println();
        System.out.println("Array after left rotation - ");
        for(int i =0;i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
