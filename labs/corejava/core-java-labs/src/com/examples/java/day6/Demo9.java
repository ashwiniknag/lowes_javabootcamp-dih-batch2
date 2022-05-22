package com.examples.java.day6;

public class Demo9 {
    public static void main(String[] args) {
        int[] a = {0, 2, 4, 1, 3};
        // System.out.println(a[0] + " " + a[1]);
       for (int i = 0; i < a.length; i++) {
            a[i] = a[(a[i] + 3) % a.length];
            System.out.println(a[i]);
        }
    }
}

