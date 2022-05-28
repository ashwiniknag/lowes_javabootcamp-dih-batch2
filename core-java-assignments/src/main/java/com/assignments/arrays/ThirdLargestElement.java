package com.assignments.arrays;
//Find 3rd Largest Number in an Array

public class ThirdLargestElement {
    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 5, 1};
        int min=0;

        for(int i=0; i< arr.length;i++){
            for(int j=i+1; j< arr.length;j++){
                if(arr[i]>arr[j]){
                    min=arr[i];
                    arr[i] =arr[j];
                    arr[j] =min;

                }

            }

        }
        System.out.println("Second Largest Element in the array is - "+ arr[arr.length-3]);

    }
}
