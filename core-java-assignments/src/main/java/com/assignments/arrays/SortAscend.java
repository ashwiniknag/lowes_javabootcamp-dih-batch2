package com.assignments.arrays;
//Java Program to sort the elements of an array in ascending order

import java.util.Arrays;
public class SortAscend {
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 5, 1};
        int min=0;
        System.out.println("original array");
        for(int i=0; i< arr.length;i++)
            System.out.print(arr[i] + " ");

        for(int i=0; i< arr.length;i++){
            for(int j=i+1; j< arr.length;j++){
               if(arr[i]>arr[j]){
                   min=arr[i];
                    arr[i] =arr[j];
                    arr[j] =min;

               }

            }

        }
        System.out.println();
        System.out.println("sorted array");
        for(int i=0; i< arr.length;i++)
            System.out.print(arr[i] + " ");


        //using sort method
        /* System.out.println();
        Arrays.sort(arr);
        System.out.println("sorted array");
        for(int i=0; i< arr.length;i++)
        System.out.print(arr[i] + " "); */


    }
}
