package com.assignments.arrays;
//Java Program to right rotate the elements of an array

public class RightRotate {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int noOfTimes = 2;
        int n;
        int j;

        System.out.println("Original array - " );
        for(int i =0;i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        //Rotate the given array by noOfTimes times towards right
        for (int i = noOfTimes; i > 0; i--) {
            n = arr[arr.length-1];

            for (j = arr.length - 1; j > 0  ; j--) {
                arr[j] = arr[j - 1];

            }
            arr[j] = n;
        }
        System.out.println();
        System.out.println("Array after right rotation - ");
        for(int i =0;i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
