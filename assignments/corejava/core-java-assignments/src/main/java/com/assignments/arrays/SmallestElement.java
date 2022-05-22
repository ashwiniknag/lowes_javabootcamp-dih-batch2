package com.assignments.arrays;
//Java Program to print the smallest element in an array

public class SmallestElement {
    public static void main(String[] args) {
        int arr[] = {7,6,3,8,2};
        int min =arr[0];
        for (int i=0; i<arr.length; i++) {
            for (int j=1; j < arr.length -1; j++){
                if(arr[i] < arr[j]) {
                    if(min > arr[i])
                        min = arr[i];

                }
            }

        }System.out.println("Smallest Element of array is - " + min);

    }
}
