package com.assignments.arrays;
// Java Program to print the duplicate elements of an array
public class DupElements {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 3, 5, 2, 7, 8, 8, 3};
        System.out.println("Duplicate elements of Array -");
        for (int i = 0; i < arr.length ; i++ ) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] == arr[j])
                    System.out.print (arr[j] + " ");

            }

        }

    }
}