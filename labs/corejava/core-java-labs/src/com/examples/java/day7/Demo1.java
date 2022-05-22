package com.examples.java.day7;

public class Demo1 {

    static void minNumber(int arrayName[]) {
        int min = arrayName[0];

        for(int i=1; i<arrayName.length; i++) {
            if(min>arrayName[i]) {
                min = arrayName[i];

            }
        }

        System.out.println(min);
    }
    public static void main(String[] args) {
        int a[] = {7, 3, 6, 8, 7, 2};
        minNumber(a);

    }
}
