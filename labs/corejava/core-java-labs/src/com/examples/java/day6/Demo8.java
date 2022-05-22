package com.examples.java.day6;

public class Demo8 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7}; ////declaration and instantiation and initialization

        for (int i=0; i< a.length; i++) {
            System.out.println(a[i]);
        }
        for (int num : a) {
            System.out.println(num);
        }
    }
}
