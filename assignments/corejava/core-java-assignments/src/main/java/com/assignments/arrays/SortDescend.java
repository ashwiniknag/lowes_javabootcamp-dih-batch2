package com.assignments.arrays;
// Java Program to sort the elements of an array in descending order

public class SortDescend {
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 5, 1};
        int max=arr[arr.length-1];
        System.out.println("original array");
        for(int i=0; i< arr.length;i++)
            System.out.print(arr[i] + " ");

        for(int i=0; i< arr.length;i++){
            for(int j=i+1; j< arr.length;j++){
                if(arr[i]<arr[j]){
                    max=arr[i];
                    arr[i] =arr[j];
                    arr[j] =max;

                }

            }

        }
        System.out.println();
        System.out.println("sorted array");
        for(int i=0; i< arr.length;i++)
            System.out.print(arr[i] + " ");
    }
}
