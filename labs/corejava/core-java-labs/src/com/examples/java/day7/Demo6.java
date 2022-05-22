package com.examples.java.day7;

public class Demo6 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        for(int i:arr){
            System.out.println(i);
        }

        int newArray[] = arr.clone();
        for(int i:newArray) {
            System.out.println(i);
        }

        System.out.println(arr == newArray); //false

    }
}
