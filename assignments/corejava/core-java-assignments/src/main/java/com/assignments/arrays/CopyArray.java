package com.assignments.arrays;
//Java Program to copy all elements of one array into another array

public class CopyArray {
    public static void main(String[] args) {
        int srcArray[] = {2, 4, 6, 8};
        int desArray[] = new int[4];


        for (int i = 0; i < srcArray.length; i++) {
            desArray[i] = srcArray[i];
            System.out.print(desArray[i] + " ");
        }

    }
}
