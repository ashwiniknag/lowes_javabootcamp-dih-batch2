package com.examples.java.day6;

public class Demo6 {
    public static void main(String[] args) {
        System.out.println("Performance Test");
        long startTime = System.currentTimeMillis();

        StringBuffer sb1 = new StringBuffer("Hello");
        for (int i=0; i<100000;i++) {
            sb1.append("World");
        }
        System.out.println("Time taken by SpringBuffer - " + (System.currentTimeMillis()-startTime) + "ms");

        System.out.println("*********************************************");

        startTime = System.currentTimeMillis();

        StringBuilder sb2 = new StringBuilder("Hello");
        for (int i=0; i<100000;i++) {
            sb2.append("World");
        }
        System.out.println("Time taken by SpringBuilder - " + (System.currentTimeMillis()-startTime) + "ms");


    }
}
