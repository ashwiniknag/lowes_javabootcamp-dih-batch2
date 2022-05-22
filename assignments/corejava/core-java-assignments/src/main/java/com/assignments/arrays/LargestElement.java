package com.assignments.arrays;
//Java Program to print the largest element in an array

public class LargestElement {
    public static void main(String[] args) {
        int arr[] = {1,6,4,3,7};
          int max = arr[0];
          for (int i=0; i<arr.length; i++) {
              for (int j=1; j < arr.length -1; j++){
                 if(arr[i] > arr[j]) {
                     if(max < arr[i])
                       max = arr[i];

                 }
              }

          }System.out.println("Largest Element of array is - " + max);

    }
}
