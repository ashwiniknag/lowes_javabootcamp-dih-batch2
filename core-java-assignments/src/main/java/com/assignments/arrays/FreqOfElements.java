package com.assignments.arrays;
//Java Program to find the frequency of each element in the array

public class FreqOfElements {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,2,2};
        int count =1;
        for (int i = 0; i < arr.length ; i++ ) {
            for(int j = 1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }

            }
            System.out.println("frequency of " +arr[i] + " - "+ count);
            count=0;
        }
    }
}
