package com.examples.java.day7;
//array of arrays with different number of columns - jagged array

public class Demo4 {
    public static void main(String[] args) {
        int arr[][]=new int[3][];
        arr[0] = new int[3];
        arr[1] = new int[4];
        arr[2] = new int[2];

        int count =0;

        for(int i=0;i<arr.length; i++){
            for (int j=0; j< arr[i].length; j++) {
                arr[i][j] = count++;
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }

        /*for(int i=0;i<arr.length; i++){
            for (int j=0; j< arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }*/

    }
}
